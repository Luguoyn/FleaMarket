package com.suda.fleamarket.exception;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 本项目的自定义异常
 */
@Getter
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class FMException extends RuntimeException {
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.INTERNAL_SERVER_ERROR.getResultCode();
    /**
     * 错误信息
     */
    protected String errorMsg = StatusCode.INTERNAL_SERVER_ERROR.getResultMsg();


    public FMException() {
        super();
    }

    public FMException(ResultInfo errorInfo) {
        super(errorInfo.getResultMsg());
        this.errorCode = errorInfo.getResultCode();
        this.errorMsg = errorInfo.getResultMsg();
    }

    public FMException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo.getResultMsg(), cause);
        this.errorCode = errorInfo.getResultCode();
        this.errorMsg = errorInfo.getResultMsg();
    }

    public FMException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public FMException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public FMException(int errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
