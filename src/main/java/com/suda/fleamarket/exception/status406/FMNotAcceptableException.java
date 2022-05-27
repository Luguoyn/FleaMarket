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

    public FMNotAcceptableException() {
        super();
    }

    public FMNotAcceptableException(String message) {
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
