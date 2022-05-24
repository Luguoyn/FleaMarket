package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.Security;
import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.exception.PasswordIncorrectException;
import com.suda.fleamarket.exception.UserAlreadyExistException;
import com.suda.fleamarket.exception.UserNotExistException;
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
        if (securityMapper.selectOneByLoginName(loginName) != null) {
            throw new UserAlreadyExistException("账号名已存在");
        }

        User user = userService.createNewUser();

        Security security = new Security();
        security.setLoginName(loginName);
        security.setPassword(MD5Utils.md5WithSalt(password));
        security.setUserId(user.getId());
        securityMapper.insert(security);

        return securityMapper.selectOneByLoginName(loginName);
    }

    @Override
    public Security updatePassword(Long id, String oldPassword, String newPassword) {
        Security security = securityMapper.selectById(id);

        if (!security.getPassword().equals(MD5Utils.md5WithSalt(oldPassword))) {
            throw new PasswordIncorrectException("旧密码错误");
        }

        security.setPassword(MD5Utils.md5WithSalt(newPassword));

        updateById(security);

        return security;
    }
}




