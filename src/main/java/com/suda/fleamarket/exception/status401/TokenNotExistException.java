package com.suda.fleamarket.exception.status401;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.exception.FMException;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class TokenNotExistException extends FMException {
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.UNAUTHORIZED.getResultCode();
    /**
     * 错误信息
     */
    protected String errorMsg = StatusCode.UNAUTHORIZED.getResultMsg();

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
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
