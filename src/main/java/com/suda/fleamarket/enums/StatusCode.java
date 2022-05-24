package com.suda.fleamarket.enums;

import com.suda.fleamarket.http.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCode implements ResultInfo {
    // HTTP状态码
    SUCCESS("200", "成功"),
    BODY_NOT_MATCH("400","请求的数据格式不符"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配"),
    FORBIDDEN("403","拒绝执行"),
    NOT_FOUND("404", "未找到该资源"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    SERVER_BUSY("503","服务器正忙，请稍后再试");


    /** 错误码 */
    private final String resultCode;

    /** 错误描述 */
    private final String resultMsg;
}
