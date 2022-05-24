package com.suda.fleamarket.http;

import com.alibaba.fastjson.JSONObject;
import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.utils.JSONUtils;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultBody {

    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object data;


    public ResultBody setCode(String code) {
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

    public ResultBody(ResultInfo resultInfo) {
        this.code = resultInfo.getResultCode();
        this.message = resultInfo.getResultMsg();
    }

    /**
     * 成功
     */
    public static ResultBody success(Object data) {
        return new ResultBody(StatusCode.SUCCESS).setData(data);
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
    public static ResultBody error(ResultInfo errorInfo) {
        return new ResultBody(errorInfo);
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        return new ResultBody().setCode(code).setMessage(message);
    }

    /**
     * 失败
     */
    public static ResultBody error() {
        return new ResultBody(StatusCode.INTERNAL_SERVER_ERROR);
    }

    @Override
    public String toString() {
        return JSONUtils.toJSON(this);
    }
}
