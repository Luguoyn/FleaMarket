package com.suda.fleamarket.utils;

import com.alibaba.fastjson.JSONObject;

public class JSONUtils {
    public static String toJSON(Object object){
        return JSONObject.toJSONString(object);
    }

    public static<T> Object parseObject(String json, Class<T> tClass){
        return JSONObject.parseObject(json, tClass);
    }
}
