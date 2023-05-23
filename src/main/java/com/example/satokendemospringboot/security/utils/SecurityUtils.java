package com.example.satokendemospringboot.security.utils;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.satokendemospringboot.security.domain.LoginUser;
import com.example.satokendemospringboot.security.enums.DeviceType;

/**
 * @author 饕餮者也
 * @date 2023-05-23 16:55
 * @description: <p>安全工具类</p>
 */
public class SecurityUtils {
    public static final String LOGIN_USER_KEY = "loginUser";

    /**
     * 基于设备类型登陆系统
     * 针对相同用户不同设备
     *
     * @param loginUser  登陆用户信息
     * @param deviceType 设备类型
     */
    public static void loginByDevice(LoginUser loginUser, DeviceType deviceType) {
        SaHolder.getStorage().set(LOGIN_USER_KEY, loginUser);
        StpUtil.login(loginUser.getUserId(), deviceType.name());
        setLoginUser(loginUser);
    }

    /**
     * 设置用户数据
     * 多重缓存
     *
     * @param loginUser 登陆用户信息
     */
    public static void setLoginUser(LoginUser loginUser) {
        StpUtil.getTokenSession().set(LOGIN_USER_KEY, loginUser);
    }

    /**
     * 获取用户数据
     * 多重缓存
     *
     * @return 登陆用户数据
     */
    public static LoginUser getLoginUser() {
        LoginUser loginUser = (LoginUser) SaHolder.getStorage().get(LOGIN_USER_KEY);
        if (ObjectUtil.isNotNull(loginUser)) {
            return loginUser;
        }
        loginUser = (LoginUser) StpUtil.getTokenSession().get(LOGIN_USER_KEY);
        SaHolder.getStorage().set(LOGIN_USER_KEY, loginUser);
        return loginUser;
    }

    /**
     * 获取用户账户
     *
     * @return 登录名
     */
    public static String getUserName() {
        return getLoginUser().getUsername();
    }

    /**
     * 根据用户id判断用户是否是管理员
     *
     * @param userId 用户 id
     * @return 是否是管理员
     */
    public static boolean isAdmin(Long userId) {
        return userId == 1 && ObjectUtil.isNotNull(userId);
    }

    /**
     * 判断当前用户是否是管理员
     *
     * @return 是否是管理员
     */
    public static boolean isAdmin() {
        return isAdmin(getLoginUser().getUserId());
    }
}
