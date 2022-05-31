package com.suda.fleamarket.controller;

import com.suda.fleamarket.anno.CurrentUserId;
import com.suda.fleamarket.dto.SecurityDTO;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.SecurityService;
import com.suda.fleamarket.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    // 这个方法不会被拦下来
    @PostMapping("/login")
    public ResultBody login(@RequestBody SecurityDTO securityDTO) {
        return ResultBody.success()
                .setMessage("登录成功")
                .setData(JWTUtils.getToken(securityService.login(securityDTO.getLoginName(), securityDTO.getPassword())));
    }

    @PostMapping("/register")
    public ResultBody register(@RequestBody SecurityDTO securityDTO) {
        return ResultBody.success()
                .setMessage("注册成功")
                .setData(JWTUtils.getToken(securityService.register(securityDTO.getLoginName(), securityDTO.getPassword())));
    }

    /**
     * 修改密码
     */
    @PostMapping("/update")
    public ResultBody updatePassword(@CurrentUserId Long currentUserId,
                                     @RequestBody SecurityDTO securityDTO) {
        return ResultBody.success()
                .setMessage("密码修改成功")
                .setData(JWTUtils.getToken(securityService.updatePassword(
                        currentUserId, securityDTO.getPassword(), securityDTO.getNewPassword())));
    }

    // 如果没有登陆的话, 这个方法应该会被拦下来
    @PostMapping("/hello")
    public ResultBody hello() {
        return ResultBody.success().setData("你好");
    }
}
