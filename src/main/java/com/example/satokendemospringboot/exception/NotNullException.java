package com.example.satokendemospringboot.exception;

/**
 * @author 饕餮者也
 * @date 2023-05-24 14:55
 * @description: <p>不能为空异常</p>
 */
public class NotNullException extends RuntimeException {

    public NotNullException(String message) {
        super(message);
    }
}
