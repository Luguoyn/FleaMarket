package com.suda.fleamarket.exception.status500;

import com.suda.fleamarket.exception.FMException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FMInternalServerErrorException extends FMException {
    /**
     * 错误码
     */
    protected final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public FMInternalServerErrorException() {
        super();
    }

    public FMInternalServerErrorException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
