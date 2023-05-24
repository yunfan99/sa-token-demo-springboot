package com.example.satokendemospringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.satokendemospringboot.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
* @author hob
* @description 针对表【tb_permissions】的数据库操作Mapper
* @createDate 2023-05-10 12:29:26
* @Entity com.example.satokendemospringboot.entity.Permissions
*/
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    Set<Menu> getPerms(Set<Long> ids);
}




