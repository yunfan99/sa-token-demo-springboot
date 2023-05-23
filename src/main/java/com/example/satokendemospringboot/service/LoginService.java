package com.example.satokendemospringboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.satokendemospringboot.entity.User;
import com.example.satokendemospringboot.entity.dto.LoginDto;
import com.example.satokendemospringboot.entity.vo.LoginVo;

/**
 * @author 饕餮者也
 * @date 2023-05-23 22:19
 * @description: <p></p>
 */
public interface LoginService extends IService<User> {


    /**
     * 登录
     * @param loginDto
     * @return
     */
    LoginVo login(LoginDto loginDto);
}
