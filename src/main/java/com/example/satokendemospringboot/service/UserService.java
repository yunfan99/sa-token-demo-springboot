package com.example.satokendemospringboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.satokendemospringboot.entity.User;
import com.example.satokendemospringboot.entity.dto.UserAddDto;
import com.example.satokendemospringboot.entity.dto.UserListDto;
import com.example.satokendemospringboot.entity.vo.UserListVo;

import java.util.List;

/**
 * @author 饕餮者也
 * @date 2023-05-09 21:23
 * @description: <p></p>
 */
public interface UserService extends IService<User> {

    /**
     * 用户列表
     *
     * @param params
     * @return
     */
    List<UserListVo> userList(UserListDto params);

    /**
     * 添加用户
     *
     * @param userAddDto
     * @return
     */
    boolean addUser(UserAddDto userAddDto);
}
