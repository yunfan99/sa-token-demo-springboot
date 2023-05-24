package com.example.satokendemospringboot.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 饕餮者也
 * @date 2023-05-24 13:48
 * @description: <p>视图列表</p>
 */
@Data
public class UserListVo implements Serializable {
    private static final Long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

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
