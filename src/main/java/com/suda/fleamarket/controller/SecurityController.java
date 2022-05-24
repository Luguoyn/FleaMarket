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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    // 这个方法不会被拦下来
    @PostMapping("/login")
    public ResultBody login(String loginName, String password) {
        return ResultBody.success()
                .setMessage("登录成功")
                .setData(JWTUtils.getToken(securityService.login(loginName, password)));
    }

    @PostMapping("/register")
    public ResultBody register(String loginName, String password) {
        return ResultBody.success()
                .setMessage("注册成功")
                .setData(JWTUtils.getToken(securityService.register(loginName, password)));
    }

    /**
     * 修改密码
     */
    @PostMapping("/update")
    public ResultBody updatePassword(HttpServletRequest request, String oldPassword, String newPassword) {
        return ResultBody.success()
                .setMessage("密码修改成功")
                .setData(JWTUtils.getToken(securityService.updatePassword(
                        Long.parseLong(JWTUtils.verifyToken(request.getHeader("token")).getClaim("id").asString()),
                        oldPassword, newPassword)));
    }

    // 这个方法应该会被拦下来
    @PostMapping("/hello")
    public ResultBody hello() {
        return ResultBody.success().setData("你好");
    }
}
