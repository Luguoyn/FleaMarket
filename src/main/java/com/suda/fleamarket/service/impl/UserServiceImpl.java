package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.User;
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
        userMapper.insert(user);
        return userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, user.getName()));
    }

    @Override
    public User createNewUser() {
        return createNewUser(User.builder().name(String.valueOf(UUID.randomUUID())).build());
    }
}




