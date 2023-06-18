package com.example.satokendemospringboot.config.security.service;

import cn.dev33.satoken.stp.StpInterface;
import com.example.satokendemospringboot.entity.Menu;
import com.example.satokendemospringboot.entity.Role;
import com.example.satokendemospringboot.config.security.domain.LoginUser;
import com.example.satokendemospringboot.config.security.utils.SecurityUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author 饕餮者也
 * @date 2023-05-23 17:56
 * @description: <p>认证授权</p>
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    /**
     * 权限
     *
     * @param loginId   账号id
     * @param loginType 账号类型
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Set<Menu> permissions = loginUser.getPermissions();
        return permissions.stream().map(Menu::getCode).distinct().toList();
    }

    /**
     * 角色
     *
     * @param loginId   账号id
     * @param loginType 账号类型
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Set<Role> roles = loginUser.getRoles();
        return roles.stream().map(Role::getRoleCode).distinct().toList();
    }

}
