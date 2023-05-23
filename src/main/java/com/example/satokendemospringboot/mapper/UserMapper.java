package com.example.satokendemospringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.satokendemospringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 饕餮者也
 * @date 2023-05-09 21:22
 * @description: <p></p>
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {



}
