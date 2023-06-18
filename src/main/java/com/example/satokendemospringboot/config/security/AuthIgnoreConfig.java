package com.example.satokendemospringboot.config.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 饕餮者也
 * @date 2023-05-23 16:49
 * @description: <p>忽略的认证</p>
 */
@ConfigurationProperties(prefix = "security.ignore")
@Component
@Data
public class AuthIgnoreConfig {

    private List<String> urls;

}
