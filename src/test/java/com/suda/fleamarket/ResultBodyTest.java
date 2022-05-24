package com.suda.fleamarket;

import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.enums.Gander;
import com.suda.fleamarket.http.ResultBody;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ResultBodyTest {
    @Test
    void test() {
        User user = new User();
        user.setAddress("美国");
        user.setAuthority(Authority.SELLER);
        user.setBirthday(new Date());
        user.setGander(Gander.MALE);
        user.setName("川建国");
        user.setTelephone("123456789123");
        user.setEmail("Trump@suda.com");
        System.out.println(ResultBody.success(user));
    }

}
