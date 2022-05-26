package com.suda.fleamarket.exception.status400;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 用户不存在, 用在请求用户信息时
 * */

@Getter
public class UserNotExistException extends FMBadRequestException {
    /**
     * 错误信息
     */
    protected String message = "用户不存在";

    public UserNotExistException() {
        super();
    }

    public UserNotExistException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
