package com.example.satokendemospringboot.security.service;

import cn.dev33.satoken.stp.StpInterface;
import com.example.satokendemospringboot.security.domain.LoginUser;
import com.example.satokendemospringboot.security.utils.SecurityUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 饕餮者也
 * @date 2023-05-23 17:56
 * @description: <p>认证授权</p>
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        return new ArrayList<>(loginUser.getPermissions());
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        return new ArrayList<>(loginUser.getRoles());
    }

}
