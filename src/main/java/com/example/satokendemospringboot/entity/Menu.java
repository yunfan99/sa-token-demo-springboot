package com.example.satokendemospringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 饕餮者也
 * @date 2023-05-10 12:04
 * @description: <p>菜单</p>
 */
@TableName("tb_menu")
@Data
public class Menu implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 权限码
     */
    private String code;

    /**
     * 路径
     */
    private String path;

}
