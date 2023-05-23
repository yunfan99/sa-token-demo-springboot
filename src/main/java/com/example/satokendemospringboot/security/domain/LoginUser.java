package com.example.satokendemospringboot.security.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

/**
 * @author 饕餮者也
 * @date 2023-05-23 16:32
 * @description: <p>用户身份</p>
 */
@Data
public class LoginUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 用户ID
    private Long userId;

    // 用户名
    private String username;

    // 姓名
    private String name;

    // 角色集合
    private Set<String> roles;

    // 权限集合
    private Set<String> permissions;

}
