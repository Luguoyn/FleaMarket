package com.suda.fleamarket.exception.status406;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class IllegalOperationException extends FMNotAcceptableException {
    /**
     * 错误信息
     */
    protected String message = "非法操作";

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
