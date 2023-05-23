package com.example.satokendemospringboot;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;

import java.util.List;

/**
 * @author 饕餮者也
 * @date 2023-05-09 21:12
 * @description: <p></p>
 */
public class TestApplication {
    public static void main(String[] args) {

        String hashpw = BCrypt.hashpw("123456");
        System.out.println(hashpw);

    }
}
