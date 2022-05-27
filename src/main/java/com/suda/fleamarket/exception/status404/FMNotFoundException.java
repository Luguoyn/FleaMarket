package com.suda.fleamarket.exception.status404;

import com.suda.fleamarket.exception.FMException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FMNotFoundException extends FMException {
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.NOT_FOUND;

    public FMNotFoundException() {
        super();
    }

    public FMNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
