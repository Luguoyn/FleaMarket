package com.suda.fleamarket.enums;

import com.suda.fleamarket.http.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCode implements ResultInfo {
    // HTTP状态码
    SUCCESS(200, "成功"),
    BAD_REQUEST(400,"错误的请求"),
    UNAUTHORIZED(401, "未登录"),
    FORBIDDEN(403,"拒绝执行"),
    NOT_FOUND(404, "未找到该资源"),
    NOT_ACCEPTABLE(406,"未授权"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试");


    /** 错误码 */
    private final int resultCode;

    /** 错误描述 */
    private final String resultMsg;
}
