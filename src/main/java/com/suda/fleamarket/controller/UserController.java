package com.suda.fleamarket.controller;

import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.exception.status404.ResourcesNotFountException;
import com.suda.fleamarket.exception.status500.UnsuccessfulOperationException;
import com.suda.fleamarket.exception.status400.UserNotExistException;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.UserService;
import com.suda.fleamarket.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询user信息
     */
    @PostMapping("/info/{userId}")
    public ResultBody getUserInfo(@PathVariable Long userId) {
        User user = userService.getById(userId);
        if (user == null) {
            throw new ResourcesNotFountException("用户不存在");
        }
        return ResultBody.success().setData(user);
    }

    /**
     * 查询当前user信息
     */
    @PostMapping("/info")
    public ResultBody getUserInfo(HttpServletRequest request) {
        return getUserInfo(JWTUtils.getUserIdFromToken(request.getHeader("token")));
    }

    /**
     * 更新user信息
     */
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
