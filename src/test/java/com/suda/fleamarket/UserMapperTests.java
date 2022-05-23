package com.suda.fleamarket;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.enums.Gander;
import com.suda.fleamarket.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserMapperTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User();
        user.setAddress("中国");
        user.setAuthority(Authority.SELLER);
        user.setBirthday(new Date());
        user.setGander(Gander.MALE);
        user.setName("张三");
        user.setTelephone("123456789123");
        user.setEmail("zhangsan@suda.com");
        System.out.println(userMapper.insert(user));
    }

    @Test
    void testSelect() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void testUpdate() {
        User user = userMapper.selectList(null).get(0);
        user.setName("李四");
        userMapper.updateById(user);
    }

    @Test
    void testDelete() {
        User user = userMapper.selectList(null).get(0);
        userMapper.deleteById(user);
    }
}
