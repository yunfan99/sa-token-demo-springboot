package com.example.satokendemospringboot.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 饕餮者也
 * @date 2023-05-24 13:33
 * @description: <p>添加参数</p>
 */
@Data
public class UserAddDto implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;
}
