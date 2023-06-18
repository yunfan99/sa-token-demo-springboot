package com.example.satokendemospringboot.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.satokendemospringboot.entity.User;
import com.example.satokendemospringboot.entity.UserRole;
import com.example.satokendemospringboot.entity.dto.UserAddDto;
import com.example.satokendemospringboot.entity.dto.UserListDto;
import com.example.satokendemospringboot.entity.vo.UserListVo;
import com.example.satokendemospringboot.exception.NotNullException;
import com.example.satokendemospringboot.exception.UsernameExistException;
import com.example.satokendemospringboot.mapper.UserMapper;
import com.example.satokendemospringboot.mapper.UserRoleMapper;
import com.example.satokendemospringboot.config.security.constants.SecurityConstants;
import com.example.satokendemospringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 饕餮者也
 * @date 2023-05-09 21:25
 * @description: <p></p>
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserRoleMapper userRoleMapper;

    /**
     * 用户列表
     *
     * @param params
     * @return
     */
    @Override
    public List<UserListVo> userList(UserListDto params) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(params.getName())) {
            wrapper.eq(User::getName, params.getName());
        }
        if (StrUtil.isNotBlank(params.getUsername())) {
            wrapper.eq(User::getUsername, params.getUsername());
        }
        if (ObjectUtil.isNotNull(params.getGender())) {
            wrapper.eq(User::getGender, params.getGender());
        }
        if (ObjectUtil.isNotNull(params.getAge())) {
            wrapper.eq(User::getAge, params.getAge());
        }

        List<User> list = this.list(wrapper);
        List<UserListVo> userListVoList = new ArrayList<>();
        // 管理员不放入列表
        list.stream()
                .filter(p -> !Objects.equals(p.getId(), SecurityConstants.ADMIN_ID))
                .forEach(item -> {
                    UserListVo userListVo = new UserListVo();
                    userListVo.setId(item.getId());
                    userListVo.setName(item.getName());
                    userListVo.setUsername(item.getUsername());
                    userListVo.setAge(item.getAge());
                    userListVo.setGender(item.getGender());
                    userListVoList.add(userListVo);
                });

        return userListVoList;
    }

    /**
     * 添加用户
     *
     * @param userAddDto
     * @return
     */
    @Override
    public boolean addUser(UserAddDto userAddDto) {
        if (StrUtil.isBlank(userAddDto.getUsername())) {
            throw new NotNullException("用户名必填");
        } else if (StrUtil.isBlank(userAddDto.getPassword())) {
            throw new NotNullException("密码必填");
        } else if (StrUtil.isBlank(userAddDto.getName())) {
            throw new NotNullException("姓名必填");
        } else if (ObjectUtil.isNull(userAddDto.getAge())) {
            throw new NotNullException("年龄必填");
        } else if (ObjectUtil.isNull(userAddDto.getGender())) {
            throw new NotNullException("性别必填");
        } else if (ObjectUtil.isNull(userAddDto.getRoleId())) {
            throw new NotNullException("角色必填");
        } else if (Objects.equals(userAddDto.getRoleId(), SecurityConstants.ADMIN_ID)) {
            throw new NotNullException("不能设置为管理员角色");
        }

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, userAddDto.getUsername());
        if (ObjectUtil.isNotNull(this.getOne(wrapper))) {
            throw new UsernameExistException("用户名已存在");
        }

        User user = new User();

        user.setName(userAddDto.getName());
        user.setUsername(userAddDto.getUsername());
        user.setAge(userAddDto.getAge());
        user.setGender(userAddDto.getGender());
        user.setPassword(BCrypt.hashpw(userAddDto.getPassword()));

        boolean save = this.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(userAddDto.getRoleId());

        return save && userRoleMapper.insert(userRole) == 1;
    }
}
