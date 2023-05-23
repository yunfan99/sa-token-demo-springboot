package com.example.satokendemospringboot.mapper;

import com.example.satokendemospringboot.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author hob
* @description 针对表【tb_user_role】的数据库操作Mapper
* @createDate 2023-05-10 12:29:26
* @Entity com.example.satokendemospringboot.entity.UserRole
*/
@Mapper
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

}




