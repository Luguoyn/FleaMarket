package com.suda.fleamarket.controller;

import com.suda.fleamarket.entity.Security;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.SecurityService;
import com.suda.fleamarket.utils.JWTUtils;
import com.suda.fleamarket.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    // 这个方法不会被拦下来
    @RequestMapping("/login")
    public ResultBody login(String loginName, String password) {

        //登录
        Security security = securityService.login(loginName, password);
        System.out.println("nnn");

        //配置token
        Map<String, String> payload = new HashMap<>();
        payload.put("id", security.getId().toString());
        payload.put("userId", security.getUserId().toString());
        payload.put("password", MD5Utils.md5WithSalt(security.getPassword()));
        String token = JWTUtils.getToken(payload);

        return ResultBody.success().setMessage("登录成功").setData(token);
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
