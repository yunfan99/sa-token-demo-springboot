package com.example.satokendemospringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.satokendemospringboot.entity.UserRole;
import com.example.satokendemospringboot.service.UserRoleService;
import com.example.satokendemospringboot.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author hob
* @description 针对表【tb_user_role】的数据库操作Service实现
* @createDate 2023-05-10 12:29:26
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




