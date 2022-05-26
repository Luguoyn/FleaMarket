package com.suda.fleamarket.exception.status404;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResourcesNotFountException extends FMNotFoundException{
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.NOT_FOUND;
    /**
     * 错误信息
     */
    protected String message = "资源不存在";

    public ResourcesNotFountException() {
        super();
    }

    public ResourcesNotFountException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
