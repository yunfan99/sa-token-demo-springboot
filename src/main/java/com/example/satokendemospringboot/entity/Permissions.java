package com.example.satokendemospringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 饕餮者也
 * @date 2023-05-10 12:04
 * @description: <p></p>
 */
@TableName("tb_permissions")
@Data
public class Permissions {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 权限码
     */
    private String code;

    /**
     * 路径
     */
    private String path;

}
