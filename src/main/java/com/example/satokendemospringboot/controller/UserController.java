package com.example.satokendemospringboot.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.example.satokendemospringboot.common.R;
import com.example.satokendemospringboot.common.constants.ResultKeyConstants;
import com.example.satokendemospringboot.entity.dto.UserAddDto;
import com.example.satokendemospringboot.entity.dto.UserListDto;
import com.example.satokendemospringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author 饕餮者也
 * @date 2023-05-24 13:19
 * @description: <p>用户控制层</p>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 用户列表
     *
     * @param params
     * @return
     */
    @SaCheckPermission(value = {"user:list"})
    @GetMapping("/list")
    public R list(@RequestBody UserListDto params) {
        return R.ok().put(ResultKeyConstants.DATA, userService.userList(params));
    }

    /**
     * 添加用户
     *
     * @param userAddDto
     * @return
     */
    @SaCheckPermission(value = {"user:add"})
    @PostMapping("/add")
    public R add(@RequestBody UserAddDto userAddDto) {
        if (userService.addUser(userAddDto)) {
            return R.ok("添加成功");
        }
        return R.error("添加失败");
    }
}
