package com.example.satokendemospringboot;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaTokenDemoSpringbootApplicationTests {

    @Test
    void contextLoads() {
        SaSecureUtil.md5("123");
    }

}
