package com.suda.fleamarket.exception.status406;

import org.springframework.http.HttpStatus;

public class IllegalOperationException extends FMNotAcceptableException {
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
    /**
     * 错误信息
     */
    protected String message = "非法操作";

    @Override
    public HttpStatus getStatus() {
        return super.getStatus();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public IllegalOperationException() {
        super();
    }

    public IllegalOperationException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
