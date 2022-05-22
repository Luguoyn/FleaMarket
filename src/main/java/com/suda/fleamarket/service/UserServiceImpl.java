package com.suda.fleamarket.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.mapper.UserMapper;
import com.suda.fleamarket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
}
