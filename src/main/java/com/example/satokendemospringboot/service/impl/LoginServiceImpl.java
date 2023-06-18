package com.example.satokendemospringboot.service.impl;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.satokendemospringboot.entity.Menu;
import com.example.satokendemospringboot.entity.Role;
import com.example.satokendemospringboot.entity.User;
import com.example.satokendemospringboot.entity.dto.LoginDto;
import com.example.satokendemospringboot.entity.vo.LoginVo;
import com.example.satokendemospringboot.exception.NotHaveUserException;
import com.example.satokendemospringboot.exception.NotNullException;
import com.example.satokendemospringboot.mapper.MenuMapper;
import com.example.satokendemospringboot.mapper.RoleMapper;
import com.example.satokendemospringboot.mapper.UserMapper;
import com.example.satokendemospringboot.config.security.constants.SecurityConstants;
import com.example.satokendemospringboot.config.security.domain.LoginUser;
import com.example.satokendemospringboot.config.security.enums.DeviceType;
import com.example.satokendemospringboot.config.security.utils.SecurityUtils;
import com.example.satokendemospringboot.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 饕餮者也
 * @date 2023-05-23 22:20
 * @description: <p>登录服务</p>
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final UserMapper userMapper;

    private final RoleMapper roleMapper;

    private final MenuMapper menuMapper;

    /**
     * 登录
     *
     * @param loginDto
     * @return
     */
    @Override
    public LoginVo login(LoginDto loginDto) {
        if (StrUtil.isBlank(loginDto.getUsername())) {
            throw new NotNullException("用户名必填");
        } else if (StrUtil.isBlank(loginDto.getPassword())) {
            throw new NotNullException("密码必填");
        }
        User user = loadUserByUsername(loginDto.getUsername());
        if (!BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {
            throw new SaTokenException("账号或密码不正确");
        }
        // 构建用户信息
        LoginUser loginUser = buildLoginUser(user);
        // 生成token
        SecurityUtils.loginByDevice(loginUser, DeviceType.PC);

        LoginVo loginVo = new LoginVo();

        loginVo.setAccessToken(StpUtil.getTokenValue());

        return loginVo;
    }

    /**
     * 构建用户信息
     *
     * @param user
     * @return
     */
    private LoginUser buildLoginUser(User user) {
        LoginUser loginUser = new LoginUser();

        loginUser.setUserId(user.getId());
        loginUser.setUsername(user.getUsername());

        Set<Role> roles = roleMapper.getRoles(user.getId());

        Set<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toSet());
        Set<Menu> perms;
        if (roleIds.contains(SecurityConstants.ADMIN_ID)) {
            List<Menu> menus = menuMapper.selectList(null);
            perms = new HashSet<>(menus);
        } else {
            perms = menuMapper.getPerms(roleIds);
        }

        log.info("roles: {}", roles);
        log.info("perms: {}", perms);

        loginUser.setRoles(roles);
        loginUser.setPermissions(perms);

        return loginUser;
    }

    /**
     * 通过账号登录
     *
     * @param username
     * @return
     */
    private User loadUserByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(wrapper);
        if (ObjectUtil.isEmpty(user)) {
            throw new NotHaveUserException("不存在" + username + "用户");
        }
        return user;
    }


}
