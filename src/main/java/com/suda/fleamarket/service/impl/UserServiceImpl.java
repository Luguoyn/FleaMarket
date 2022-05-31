package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.exception.status400.UserAlreadyExistException;
import com.suda.fleamarket.exception.status404.ResourcesNotFountException;
import com.suda.fleamarket.service.UserService;
import com.suda.fleamarket.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author 32488
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-05-23 19:02:25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User createNewUser(User user) {
        if (userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, user.getName())) != null) {
            throw new UserAlreadyExistException("用户已存在");
        }
        userMapper.insert(user);
        return userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, user.getName()));
    }

    @Override
    public User createNewUser() {
        return createNewUser(User.builder().name(String.valueOf(UUID.randomUUID())).build());
    }

    @Override
    public boolean save(Long userId, User user) {
        Assert.notEmpty(user.getName(), "用户名不能为空");

        User someone = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, user.getName()));

        if (someone != null && !someone.getId().equals(userId) && someone.getName().equals(user.getName())) {
            throw new UserAlreadyExistException("用户已存在");

        }

        User old = userMapper.selectById(userId);
        if (old == null) {
            throw new ResourcesNotFountException("用户不存在");
        }
        user.setAuthority(old.getAuthority());
        user.setId(userId);
        return userMapper.updateById(user) == 1;
    }
}




