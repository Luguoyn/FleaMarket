package com.suda.fleamarket.controller;

import com.suda.fleamarket.anno.CurrentUserId;
import com.suda.fleamarket.entity.Security;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.SecurityService;
import com.suda.fleamarket.utils.JWTUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    // 这个方法不会被拦下来
    @PostMapping("/login")
    public ResultBody login(@RequestBody @Valid Security security) {
        return ResultBody.success()
                .setMessage("登录成功")
                .setData(JWTUtils.getToken(securityService.login(security.getLoginName(), security.getPassword())));
    }

    @PostMapping("/register")
    public ResultBody register(@RequestBody @Valid Security security) {
        return ResultBody.success()
                .setMessage("注册成功")
                .setData(JWTUtils.getToken(securityService.register(security.getLoginName(), security.getPassword())));
    }

    /**
     * 修改密码
     */
    @PostMapping("/update")
    public ResultBody updatePassword(@CurrentUserId Long currentUserId,
                                     @RequestBody @Valid PasswordChanger passwordChanger) {
        return ResultBody.success()
                .setMessage("密码修改成功")
                .setData(JWTUtils.getToken(securityService.updatePassword(
                        currentUserId, passwordChanger.getOldPassword(), passwordChanger.getNewPassword())));
    }

    // 如果没有登陆的话, 这个方法应该会被拦下来
    @PostMapping("/hello")
    public ResultBody hello() {
        return ResultBody.success().setData("你好");
    }


    @Data
    private static class PasswordChanger {
        @NotBlank(message = "旧密码不能为空")
        private String oldPassword;

        @NotBlank(message = "新密码不能为空")
        private String newPassword;
    }
}
