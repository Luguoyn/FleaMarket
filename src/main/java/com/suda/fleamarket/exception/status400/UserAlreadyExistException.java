package com.suda.fleamarket.exception.status400;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 用户已存在, 用在注册时, 检测security表中的登录名.
 * */

@Getter
public class UserAlreadyExistException extends FMBadRequestException {
    /**
     * 错误信息
     */
    protected String message = "用户已存在";

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(String message) {
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
