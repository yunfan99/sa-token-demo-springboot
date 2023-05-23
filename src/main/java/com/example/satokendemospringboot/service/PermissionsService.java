package com.example.satokendemospringboot.service;

import com.example.satokendemospringboot.entity.Permissions;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author hob
* @description 针对表【tb_permissions】的数据库操作Service
* @createDate 2023-05-10 12:29:26
*/
public interface PermissionsService extends IService<Permissions> {
    List<Permissions> listByRoleIdPermissions(Long roleId);
}
