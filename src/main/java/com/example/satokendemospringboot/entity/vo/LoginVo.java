package com.example.satokendemospringboot.entity.vo;

import cn.hutool.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 饕餮者也
 * @date 2023-05-23 22:24
 * @description: <p>登录信息</p>
 */
@Data
public class LoginVo implements Serializable {

    private static final Long serialVersionUID = 1L;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

}
