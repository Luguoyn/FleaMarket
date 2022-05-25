package com.suda.fleamarket.exception.status400;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 密码不正确的异常, 用在密码验证失败或token的密码验证失败时
 * */
@Getter
public class PasswordIncorrectException extends FMBadRequestException {
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.BAD_REQUEST;
    /**
     * 错误信息
     */
    protected String message = "密码错误";

    public PasswordIncorrectException() {
        super();
    }


    public PasswordIncorrectException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
