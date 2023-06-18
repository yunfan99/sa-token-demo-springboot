package com.example.satokendemospringboot.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.example.satokendemospringboot.common.R;
import com.example.satokendemospringboot.common.constants.ResultKeyConstants;
import com.example.satokendemospringboot.entity.dto.LoginDto;
import com.example.satokendemospringboot.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 饕餮者也
 * @date 2023-05-23 22:17
 * @description: <p>登录控制器</p>
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 登录
     *
     * @param loginDto
     * @return
     */
    @SaIgnore
    @PostMapping("/login")
    public R login(@RequestBody LoginDto loginDto) {

        return R.ok().put(ResultKeyConstants.LOGIN_INFO, loginService.login(loginDto));
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public R logout() {
        StpUtil.logout();
        return R.ok();
    }

}
