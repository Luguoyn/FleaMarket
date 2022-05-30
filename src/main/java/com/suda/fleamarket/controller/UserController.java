package com.suda.fleamarket.controller;

import com.suda.fleamarket.anno.CurrentUserId;
import com.suda.fleamarket.dto.UserDTO;
import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.exception.status404.ResourcesNotFountException;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        return ResultBody.success().setData(UserDTO.getFromUser(user));
    }

    /**
     * 查询当前user信息
     */
    @PostMapping("/info")
    public ResultBody getCurrentUserInfo(@CurrentUserId Long currentUserId) {
        return getUserInfo(currentUserId);
    }

    /**
     * 更新user信息
     */
    @PostMapping("/update")
    public ResultBody updateUserInfo(@CurrentUserId Long currentUserId, @Valid @RequestBody UserDTO userDTO) {
        User user = userDTO.toUser();
        user.setId(currentUserId);
        return ResultBody.success().setData(userService.updateById(user));
    }
}
