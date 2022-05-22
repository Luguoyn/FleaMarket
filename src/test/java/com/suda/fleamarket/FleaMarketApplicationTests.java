package com.suda.fleamarket;

import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.enums.Gander;
import com.suda.fleamarket.mapper.UserMapper;
import com.suda.fleamarket.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class FleaMarketApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testAddUser(){
        User user = new User();
        user.setAddress("中国");
        user.setAuthority(Authority.SELLER);
        user.setBirthday(new Date());
        user.setGander(Gander.MALE);
        user.setName("小华");
        user.setTelephone("123-1252-3632");
        System.out.println(userMapper.insert(user));
    }

}
