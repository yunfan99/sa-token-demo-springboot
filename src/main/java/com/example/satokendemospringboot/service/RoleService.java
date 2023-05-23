package com.example.satokendemospringboot.service;

import com.example.satokendemospringboot.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author hob
* @description 针对表【tb_role】的数据库操作Service
* @createDate 2023-05-10 12:29:26
*/
public interface RoleService extends IService<Role> {

    List<Role> listByUserIdRoles(Long userId);

}
