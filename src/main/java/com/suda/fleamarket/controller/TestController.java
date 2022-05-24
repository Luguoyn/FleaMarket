package com.suda.fleamarket.controller;

import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.utils.JSONUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/t1")
    public ResultBody t1(@RequestBody Map<String, Object> map) {
        map.forEach((k, v) -> {
            System.out.println(k + "::" + v);
        });
        return ResultBody.success().setData(map);
    }
}
