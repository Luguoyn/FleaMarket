package com.suda.fleamarket.http;

import com.suda.fleamarket.utils.JSONUtils;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultBody {

    /**
     * 响应代码
     */
    private int code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object data;


    public ResultBody setCode(int code) {
        this.code = code;
        return this;
    }

    public ResultBody setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResultBody setData(Object data) {
        this.data = data;
        return this;
    }

    public ResultBody(HttpStatus status) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
    }

    /**
     * 成功
     */
    public static ResultBody success(Object data) {
        return new ResultBody(HttpStatus.OK).setData(data);
    }

    /**
     * 成功
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 失败
     */
    public static ResultBody error(HttpStatus status) {
        return new ResultBody(status);
    }

    /**
     * 失败
     */
    public static ResultBody error(int code, String message) {
        return new ResultBody().setCode(code).setMessage(message);
    }

    /**
     * 失败
     */
    public static ResultBody error() {
        return new ResultBody(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public String toString() {
        return JSONUtils.toJSON(this);
    }
}
