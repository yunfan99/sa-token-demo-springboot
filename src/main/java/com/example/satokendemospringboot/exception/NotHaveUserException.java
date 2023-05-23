package com.example.satokendemospringboot.exception;

/**
 * @author 饕餮者也
 * @date 2023-05-23 22:37
 * @description: <p></p>
 */
public class NotHaveUserException extends RuntimeException {

    public NotHaveUserException(String message) {
        super(message);
    }

}
