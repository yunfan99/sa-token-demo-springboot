package com.example.satokendemospringboot.service.impl;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.satokendemospringboot.entity.Role;
import com.example.satokendemospringboot.entity.User;
import com.example.satokendemospringboot.entity.dto.LoginDto;
import com.example.satokendemospringboot.entity.vo.LoginVo;
import com.example.satokendemospringboot.exception.NotHaveUserException;
import com.example.satokendemospringboot.mapper.PermissionsMapper;
import com.example.satokendemospringboot.mapper.RoleMapper;
import com.example.satokendemospringboot.mapper.UserMapper;
import com.example.satokendemospringboot.security.domain.LoginUser;
import com.example.satokendemospringboot.security.enums.DeviceType;
import com.example.satokendemospringboot.security.utils.SecurityUtils;
import com.example.satokendemospringboot.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author 饕餮者也
 * @date 2023-05-23 22:20
 * @description: <p>登录服务</p>
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {

    private final RoleMapper roleMapper;

    private final PermissionsMapper permissionsMapper;

    /**
     * 登录
     * @param loginDto
     * @return
     */
    @Override
    public LoginVo login(LoginDto loginDto) {
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
     * @param user
     * @return
     */
    private LoginUser buildLoginUser(User user) {
        LoginUser loginUser =new LoginUser();

        loginUser.setUserId(user.getId());
        loginUser.setUsername(user.getUsername());

        Set<String> roles = roleMapper.getRoles(user.getId());
        Set<String> perms = permissionsMapper.getPerms(user.getId());
        log.info("roles: {}", roles);
        log.info("perms: {}", perms);

        loginUser.setRoles(roles);
        loginUser.setPermissions(perms);

        return loginUser;
    }

    /**
     * 通过账号登录
     * @param username
     * @return
     */
    private User loadUserByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user = this.baseMapper.selectOne(wrapper);
        if (ObjectUtil.isEmpty(user)) {
            throw new NotHaveUserException("登录用户：" + username + " 不存在.");
        }
        return user;
    }


}
