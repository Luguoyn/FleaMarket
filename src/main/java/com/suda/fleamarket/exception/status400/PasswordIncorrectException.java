package com.suda.fleamarket.exception.status400;

import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 密码不正确的异常, 用在密码验证失败或token的密码验证失败时
 * */
@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PasswordIncorrectException extends FMBadRequestException {
    /**
     * 错误信息
     */
    protected String errorMsg = "密码错误";

    public PasswordIncorrectException() {
        super();
    }

    public PasswordIncorrectException(ResultInfo errorInfo) {
        super(errorInfo);
    }

    public PasswordIncorrectException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }

    public PasswordIncorrectException(String errorMsg) {
        super(errorMsg);
    }

    public PasswordIncorrectException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public PasswordIncorrectException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
