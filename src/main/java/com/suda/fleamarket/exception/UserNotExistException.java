package com.suda.fleamarket.exception;

import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户不存在, 用在请求用户信息时
 * */

@Getter
@Setter
public class UserNotExistException extends FMException{
    /**
     * 错误码
     */
    protected String errorCode = "404";
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

    public UserNotExistException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public UserNotExistException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
