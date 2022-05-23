package com.suda.fleamarket;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.enums.Gander;
import com.suda.fleamarket.mapper.UserMapper;
import com.suda.fleamarket.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PageTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void testPage() {
        Page<User> userPage = new Page<>(1, 3);
        userMapper.selectPage(userPage, new LambdaQueryWrapper<User>().eq(User::getGander, Gander.MALE));
        userPage.getRecords().forEach(System.out::println);
    }
}
