package com.suda.fleamarket.exception.status400;

import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 用户不存在, 用在请求用户信息时
 * */

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserNotExistException extends FMBadRequestException {
    /**
     * 错误信息
     */
    protected String errorMsg = "用户不存在";

    public UserNotExistException() {
        super();
    }

    public UserNotExistException(ResultInfo errorInfo) {
        super(errorInfo);
    }

    public UserNotExistException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }

    public UserNotExistException(String errorMsg) {
        super(errorMsg);
    }

    public UserNotExistException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public UserNotExistException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
