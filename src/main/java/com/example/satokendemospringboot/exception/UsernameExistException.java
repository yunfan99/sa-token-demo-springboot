package com.example.satokendemospringboot.exception;

/**
 * @author 饕餮者也
 * @date 2023-05-24 14:53
 * @description: <p>用户名存在异常</p>
 */
public class UsernameExistException extends RuntimeException {

    public UsernameExistException(String message) {
        super(message);
    }
}
