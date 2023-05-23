package com.example.satokendemospringboot.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.example.satokendemospringboot.common.R;
import com.example.satokendemospringboot.entity.dto.LoginDto;
import com.example.satokendemospringboot.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @SaIgnore
    @PostMapping("/login")
    public R login(@RequestBody LoginDto loginDto) {
        return R.ok().put(loginService.login(loginDto));
    }


    @PostMapping("/logout")
    public R logout() {
        StpUtil.logout();
        return R.ok();
    }

}
