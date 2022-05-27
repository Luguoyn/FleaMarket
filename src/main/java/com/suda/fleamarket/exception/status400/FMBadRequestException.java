package com.suda.fleamarket.exception.status400;

import com.suda.fleamarket.exception.FMException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FMBadRequestException extends FMException {
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.BAD_REQUEST;

    public FMBadRequestException() {
        super();
    }

    public FMBadRequestException(String message) {
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
