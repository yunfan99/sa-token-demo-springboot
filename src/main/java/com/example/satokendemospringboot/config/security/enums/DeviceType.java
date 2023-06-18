package com.example.satokendemospringboot.config.security.enums;

import lombok.Data;

/**
 * @author 饕餮者也
 * @date 2023-05-23 16:43
 * @description: <p>设备登陆类型</p>
 */
public enum DeviceType {
    PC("pc"),

    APP("app");

    private final String device;

    DeviceType(String device) {
        this.device = device;
    }

    public String getDevice() {
        return device;
    }
}
