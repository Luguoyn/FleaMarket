package com.suda.fleamarket.exception;

import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 本项目的自定义异常
 */
@Getter
@Setter
public class FMException extends RuntimeException {
    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public FMException() {
        super();
    }

    public FMException(ResultInfo errorInfo) {
        super(errorInfo.getResultCode());
        this.errorCode = errorInfo.getResultCode();
        this.errorMsg = errorInfo.getResultMsg();
    }

    public FMException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo.getResultCode(), cause);
        this.errorCode = errorInfo.getResultCode();
        this.errorMsg = errorInfo.getResultMsg();
    }

    public FMException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public FMException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public FMException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
