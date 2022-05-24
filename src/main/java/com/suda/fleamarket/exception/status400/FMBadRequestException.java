package com.suda.fleamarket.exception.status400;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.exception.FMException;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FMBadRequestException extends FMException {
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.BAD_REQUEST.getResultCode();

    public FMBadRequestException() {
        super();
    }

    public FMBadRequestException(ResultInfo errorInfo) {
        super(errorInfo);
    }

    public FMBadRequestException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }

    public FMBadRequestException(String errorMsg) {
        super(errorMsg);
    }

    public FMBadRequestException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public FMBadRequestException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
