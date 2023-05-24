package com.example.satokendemospringboot.mapper;

import com.example.satokendemospringboot.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
* @author hob
* @description 针对表【tb_role】的数据库操作Mapper
* @createDate 2023-05-10 12:29:26
* @Entity com.example.satokendemospringboot.entity.Role
*/
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    Set<Role> getRoles(Long id);
}




