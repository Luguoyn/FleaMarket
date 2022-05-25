package com.suda.fleamarket.exception.status500;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UnsuccessfulOperationException extends FMInternalServerErrorException {
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    /**
     * 错误信息
     */
    protected String message = "操作失败";

    public UnsuccessfulOperationException() {
        super();
    }

    public UnsuccessfulOperationException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

}
