package com.suda.fleamarket.exception;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户不存在, 用在请求用户信息时
 * */

@Getter
public class UserNotExistException extends FMException{
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.NOT_FOUND.getResultCode();
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
    public FMException setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    @Override
    public FMException setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
