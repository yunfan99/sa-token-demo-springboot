package com.example.satokendemospringboot.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.satokendemospringboot.entity.User;
import com.example.satokendemospringboot.mapper.UserMapper;
import com.example.satokendemospringboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 饕餮者也
 * @date 2023-05-09 21:25
 * @description: <p></p>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
