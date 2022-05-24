package com.suda.fleamarket.controller;

import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.exception.UnsuccessfulOperationException;
import com.suda.fleamarket.exception.UserNotExistException;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.UserService;
import com.suda.fleamarket.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/info")
    public ResultBody getUserInfo(Long userId) {
        User user = userService.getById(userId);
        if (user == null) {
            throw new UserNotExistException("用户不存在");
        }
        return ResultBody.success().setData(user);
    }

    @PostMapping("/update")
    public ResultBody updateUserInfo(HttpServletRequest request, @Valid @RequestBody User user) {
        user.setId(JWTUtils.getUserIdFromToken(request.getHeader("token")));
        boolean flag = userService.saveOrUpdate(user);
        if (!flag) {
            throw new UnsuccessfulOperationException("更新用户信息失败");
        }
        return ResultBody.success();
    }
}
