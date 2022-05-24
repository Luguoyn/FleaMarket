package com.suda.fleamarket.exception;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户已存在, 用在注册时, 检测security表中的登录名.
 * */

@Getter

public class UserAlreadyExistException extends FMException{
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.FORBIDDEN.getResultCode();
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
