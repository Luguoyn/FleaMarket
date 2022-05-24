package com.suda.fleamarket.exception;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;

@Getter
public class UnsuccessfulOperationException extends FMException{
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.INTERNAL_SERVER_ERROR.getResultCode();
    /**
     * 错误信息
     */
    protected String errorMsg = "操作失败";

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

    public UnsuccessfulOperationException() {
        super();
    }

    public UnsuccessfulOperationException(ResultInfo errorInfo) {
        super(errorInfo);
    }

    public UnsuccessfulOperationException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }

    public UnsuccessfulOperationException(String errorMsg) {
        super(errorMsg);
    }

    public UnsuccessfulOperationException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public UnsuccessfulOperationException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

}
