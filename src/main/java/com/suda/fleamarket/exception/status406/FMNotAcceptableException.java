package com.suda.fleamarket.exception.status406;

import com.suda.fleamarket.exception.FMException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FMNotAcceptableException extends FMException {
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.NOT_ACCEPTABLE;

    @Override
    public HttpStatus getStatus() {
        return super.getStatus();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public FMNotAcceptableException() {
        super();
    }

    public FMNotAcceptableException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
