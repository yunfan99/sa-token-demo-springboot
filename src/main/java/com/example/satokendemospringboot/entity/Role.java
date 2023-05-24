package com.example.satokendemospringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 饕餮者也
 * @date 2023-05-10 12:03
 * @description: <p>角色</p>
 */
@TableName("tb_role")
@Data
public class Role implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 角色码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;
}
