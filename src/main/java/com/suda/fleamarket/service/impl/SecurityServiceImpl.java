package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.Security;
import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.exception.status400.PasswordIncorrectException;
import com.suda.fleamarket.exception.status400.UserAlreadyExistException;
import com.suda.fleamarket.exception.status400.UserNotExistException;
import com.suda.fleamarket.service.SecurityService;
import com.suda.fleamarket.mapper.SecurityMapper;
import com.suda.fleamarket.service.UserService;
import com.suda.fleamarket.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 32488
 * @description 针对表【security】的数据库操作Service实现
 * @createDate 2022-05-23 18:58:09
 */
@Service
public class SecurityServiceImpl extends ServiceImpl<SecurityMapper, Security>
        implements SecurityService {
    @Autowired
    SecurityMapper securityMapper;

    @Autowired
    UserService userService;

    @Override
    public Security login(String loginName, String password) {
        Security security = securityMapper.selectOneByLoginName(loginName);
        if (security == null) {
            throw new UserNotExistException("用户不存在");
        }

        if (!security.getPassword().equals(MD5Utils.md5WithSalt(password))) {
            throw new PasswordIncorrectException("密码错误");
        }

        return security;
    }

    @Override
    public Security register(String loginName, String password) {
        Assert.notEmpty(loginName, "用户名不能为空");
        Assert.notEmpty(password, "密码不能为空");

        if (securityMapper.selectOneByLoginName(loginName) != null) {
            throw new UserAlreadyExistException("账号已存在");
        }

        User user = userService.createNewUser();

        securityMapper.insert(Security.builder()
                .loginName(loginName).password(MD5Utils.md5WithSalt(password)).userId(user.getId())
                .build());

        return securityMapper.selectOneByLoginName(loginName);
    }

    @Override
    public Security updatePassword(Long userId, String oldPassword, String newPassword) {
        Assert.notEmpty(newPassword, "新密码不能为空");
        Security security = securityMapper.selectOneByUserId(userId);

        if (!security.getPassword().equals(MD5Utils.md5WithSalt(oldPassword))) {
            throw new PasswordIncorrectException("旧密码错误");
        }

        security.setPassword(MD5Utils.md5WithSalt(newPassword));

        updateById(security);

        return security;
    }
}




