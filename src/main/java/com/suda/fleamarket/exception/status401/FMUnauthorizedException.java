package com.suda.fleamarket.exception.status401;

import com.suda.fleamarket.exception.FMException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FMUnauthorizedException extends FMException {
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.UNAUTHORIZED;

    public FMUnauthorizedException() {
        super();
    }

    public FMUnauthorizedException(String message) {
        this.message = message;
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
