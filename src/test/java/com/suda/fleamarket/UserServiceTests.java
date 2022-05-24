package com.suda.fleamarket;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.enums.Gander;
import com.suda.fleamarket.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    UserService userService;

    @Test
    void testList() {
        userService.list().forEach(System.out::println);
    }

    @Test
    void testGet(){
        System.out.println(userService.getById(1528707041789485057L));
    }

    @Test
    void testSave() {
        User user = new User();
        user.setAddress("美国");
        user.setAuthority(Authority.SELLER);
        user.setBirthday(new Date());
        user.setGander(Gander.MALE);
        user.setName("川建国");
        user.setTelephone("123456789123");
        user.setEmail("Trump@suda.com");
        userService.save(user);
    }

    @Test
    void testRemove() {
        userService.remove(new LambdaQueryWrapper<User>().like(User::getName, "四"));
    }
}
