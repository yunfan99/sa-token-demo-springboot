package com.example.satokendemospringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 饕餮者也
 * @date 2023-05-10 12:12
 * @description: <p>角色 - 权限</p>
 */
@TableName("tb_role_menu")
@Data
public class RoleMenu {

    private static final Long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 权限id
     */
    private Long menuId;
}
