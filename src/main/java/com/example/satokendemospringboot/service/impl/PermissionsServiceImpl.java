package com.example.satokendemospringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.satokendemospringboot.entity.Permissions;
import com.example.satokendemospringboot.service.PermissionsService;
import com.example.satokendemospringboot.mapper.PermissionsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author hob
* @description 针对表【tb_permissions】的数据库操作Service实现
* @createDate 2023-05-10 12:29:26
*/
@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions>
    implements PermissionsService{

    @Override
    public List<Permissions> listByRoleIdPermissions(Long roleId) {
        return this.baseMapper.listByRoleIdPermissions(roleId);
    }
}




