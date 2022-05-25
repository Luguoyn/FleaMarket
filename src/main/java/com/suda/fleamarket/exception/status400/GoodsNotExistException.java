package com.suda.fleamarket.exception.status400;

import org.springframework.http.HttpStatus;

public class GoodsNotExistException extends FMBadRequestException {
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.BAD_REQUEST;
    /**
     * 错误信息
     */
    protected String message = "商品不存在";

    @Override
    public HttpStatus getStatus() {
        return super.getStatus();
    }

    public GoodsNotExistException() {
        super();
    }

    public GoodsNotExistException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
