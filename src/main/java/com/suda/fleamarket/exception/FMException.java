package com.suda.fleamarket.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 本项目的自定义异常
 */
@Getter
public class FMException extends RuntimeException {
    /**
     * 错误码
     */
    protected HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    /**
     * 错误信息
     */
    protected String message = "服务器内部错误";

    public FMException() {
        super();
    }

    public FMException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
