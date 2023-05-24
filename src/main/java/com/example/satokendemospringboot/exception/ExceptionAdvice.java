package com.example.satokendemospringboot.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.example.satokendemospringboot.common.R;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 饕餮者也
 * @date 2023-05-10 10:31
 * @description: <p>异常通知</p>
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotLoginException.class)
    public R notLoginException(NotLoginException nle) {

        // 打印堆栈，以供调试
        nle.printStackTrace();

        String message = "";
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "请先登陆";
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        } else {
            message = "未知异常";
        }

        // 返回给前端
        return R.error(message);
    }

    @ExceptionHandler(NotPermissionException.class)
    public R notPermissionException(NotPermissionException npe) {

        npe.printStackTrace();

        return R.error("没有权限");

    }

    @ExceptionHandler(NotHaveUserException.class)
    public R notHaveUserException(NotHaveUserException e) {
        e.printStackTrace();
        return R.error(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public R dataIntegrityViolationException(DataIntegrityViolationException e) {
        e.printStackTrace();
        return R.error("数据参数异常");
    }

    @ExceptionHandler(BindException.class)
    public R validatedBindException(BindException e) {
        e.printStackTrace();
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return R.error(message);
    }

    @ExceptionHandler(Exception.class)
    public R exception(Exception e) {
        e.printStackTrace();
        return R.error(e.getMessage());
    }

    @ExceptionHandler(UsernameExistException.class)
    public R usernameExistException(UsernameExistException e) {
        e.printStackTrace();
        return R.error(e.getMessage());
    }

    @ExceptionHandler(NotNullException.class)
    public R notNullException(NotNullException e) {
        e.printStackTrace();
        return R.error(e.getMessage());
    }
}
