package com.suda.fleamarket.controller;

import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    // 这个方法不会被拦下来
    @PostMapping("/login")
    public ResultBody login() {
        return ResultBody.success().setData("你在登陆");
    }

    @PostMapping("/register")
    public ResultBody register() {
        return null;
    }

    @PostMapping("/change-password")
    public ResultBody changePassword(@RequestBody Map<String, Object> map) {
        return null;
    }

    // 这个方法应该会被拦下来
    @PostMapping("/hello")
    public ResultBody hello() {
        return ResultBody.success().setData("你好");
    }
}
