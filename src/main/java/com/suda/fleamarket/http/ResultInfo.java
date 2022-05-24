package com.suda.fleamarket.http;

public interface ResultInfo {
    /** 错误码*/
    int getResultCode();

    /** 错误描述*/
    String getResultMsg();
}
