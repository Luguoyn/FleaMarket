package com.suda.fleamarket.exception;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 密码不正确的异常, 用在密码验证失败或token的密码验证失败时
 * */
@Getter
public class PasswordIncorrectException extends FMException{
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.FORBIDDEN.getResultCode();
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
