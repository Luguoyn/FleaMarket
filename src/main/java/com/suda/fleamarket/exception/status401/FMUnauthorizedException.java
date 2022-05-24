package com.suda.fleamarket.exception.status401;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.exception.FMException;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class FMUnauthorizedException extends FMException {
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.UNAUTHORIZED.getResultCode();

    public FMUnauthorizedException() {
        super();
    }

    public FMUnauthorizedException(ResultInfo errorInfo) {
        super(errorInfo);
    }

    public FMUnauthorizedException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }

    public FMUnauthorizedException(String errorMsg) {
        super(errorMsg);
    }

    public FMUnauthorizedException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public FMUnauthorizedException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
