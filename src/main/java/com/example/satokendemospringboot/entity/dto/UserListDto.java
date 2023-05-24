package com.example.satokendemospringboot.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 饕餮者也
 * @date 2023-05-24 13:22
 * @description: <p>用户查询信息</p>
 */
@Data
public class UserListDto implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;
}
