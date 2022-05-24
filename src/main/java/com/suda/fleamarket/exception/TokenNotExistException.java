package com.suda.fleamarket.exception;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;

@Getter
public class TokenNotExistException extends FMException{
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.NOT_LOGGED_IN.getResultCode();
    /**
     * 错误信息
     */
    protected String errorMsg = StatusCode.NOT_LOGGED_IN.getResultMsg();

    public TokenNotExistException() {
        super();
    }

    public TokenNotExistException(ResultInfo errorInfo) {
        super(errorInfo);
    }

    public TokenNotExistException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }

    public TokenNotExistException(String errorMsg) {
        super(errorMsg);
    }

    public TokenNotExistException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public TokenNotExistException(int errorCode, String errorMsg, Throwable cause) {
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
