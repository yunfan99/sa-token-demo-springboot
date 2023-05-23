package com.example.satokendemospringboot.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 饕餮者也
 * @date 2023-05-23 22:28
 * @description: <p>登录信息</p>
 */
@Data
public class LoginDto implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String username;

    private String password;

}
