package com.suda.fleamarket.exception;

import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenNotExistException extends FMException{
    /**
     * 错误码
     */
    protected String errorCode = "403";
    /**
     * 错误信息
     */
    protected String errorMsg = "未登录";

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

    public TokenNotExistException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public TokenNotExistException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
