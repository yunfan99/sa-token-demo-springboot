package com.example.satokendemospringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.satokendemospringboot.entity.Role;
import com.example.satokendemospringboot.entity.User;
import com.example.satokendemospringboot.service.RoleService;
import com.example.satokendemospringboot.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author hob
* @description 针对表【tb_role】的数据库操作Service实现
* @createDate 2023-05-10 12:29:26
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




