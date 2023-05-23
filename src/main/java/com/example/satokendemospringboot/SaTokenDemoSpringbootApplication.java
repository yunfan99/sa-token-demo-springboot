package com.example.satokendemospringboot;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaTokenDemoSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaTokenDemoSpringbootApplication.class, args);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }

}
