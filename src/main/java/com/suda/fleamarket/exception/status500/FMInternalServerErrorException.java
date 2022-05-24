package com.suda.fleamarket.exception.status500;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.exception.FMException;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class FMInternalServerErrorException extends FMException {
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.INTERNAL_SERVER_ERROR.getResultCode();

    public FMInternalServerErrorException() {
        super();
    }

    public FMInternalServerErrorException(ResultInfo errorInfo) {
        super(errorInfo);
    }

    public FMInternalServerErrorException(ResultInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }

    public FMInternalServerErrorException(String errorMsg) {
        super(errorMsg);
    }

    public FMInternalServerErrorException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public FMInternalServerErrorException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
