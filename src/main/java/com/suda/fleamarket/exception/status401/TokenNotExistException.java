package com.suda.fleamarket.exception.status401;

import com.suda.fleamarket.exception.FMException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TokenNotExistException extends FMUnauthorizedException {
    /**
     * 错误信息
     */
    protected String message = "请先登录";

    public TokenNotExistException() {
        super();
    }


    public TokenNotExistException(String message) {
        super(message);
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
