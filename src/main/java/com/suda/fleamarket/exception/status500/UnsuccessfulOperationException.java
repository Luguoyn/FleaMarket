package com.suda.fleamarket.exception.status500;

import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.exception.FMException;
import com.suda.fleamarket.http.ResultInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class UnsuccessfulOperationException extends FMInternalServerErrorException {
    /**
     * 错误码
     */
    protected int errorCode = StatusCode.INTERNAL_SERVER_ERROR.getResultCode();
    /**
     * 错误信息
     */
    protected String errorMsg = "操作失败";

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
