package com.example.satokendemospringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.satokendemospringboot.entity.UserPermissions;
import com.example.satokendemospringboot.service.RolePermissionsService;
import com.example.satokendemospringboot.mapper.RolePermissionsMapper;
import org.springframework.stereotype.Service;

/**
* @author hob
* @description 针对表【tb_role_permissions】的数据库操作Service实现
* @createDate 2023-05-10 12:29:26
*/
@Service
public class RolePermissionsServiceImpl extends ServiceImpl<RolePermissionsMapper, UserPermissions>
    implements RolePermissionsService{

}




