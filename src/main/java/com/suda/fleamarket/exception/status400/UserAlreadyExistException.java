package com.suda.fleamarket.exception.status400;

import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 用户已存在, 用在注册时, 检测security表中的登录名.
 * */

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserAlreadyExistException extends FMBadRequestException {
    /**
     * 错误信息
     */
    protected String errorMsg = "用户已存在";

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(ResultInfo errorInfo) {
        super(errorInfo);
    }

    public UserAlreadyExistException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }

    public UserAlreadyExistException(String errorMsg) {
        super(errorMsg);
    }

    public UserAlreadyExistException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public UserAlreadyExistException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
