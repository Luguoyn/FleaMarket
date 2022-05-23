package com.suda.fleamarket;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;

@SpringBootTest
public class JWTTest {
    @Test
    void getToken() {
        HashMap<String, Object> header = new HashMap<>();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 10);

        String token = JWT.create()
//                .withHeader(header) //header
                .withClaim("userId", 123) // payload, 用于存放不敏感数据
                .withClaim("username", "张三")
                .withExpiresAt(instance.getTime()) // 设置token过期时间
                .sign(Algorithm.HMAC256("i215s*F(@4hu#%saf14&"));// 签名, 十分重要不可暴露

        System.out.println(token);
    }

    @Test
    void verifyToken(){
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("i215s*F(@4hu#%saf14&")).build();

        //验证cookie
        DecodedJWT verify = null;
        try {
            verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NTMzMTQxMzEsInVzZXJJZCI6MTIzLCJ1c2VybmFtZSI6IuW8oOS4iSJ9.3mhPzjJ5nv2DTFW7tDxlP2DbW9IEni_6PQ9fIzvcQ8U");
            System.out.println(verify.getClaim("userId"));
            System.out.println(verify.getClaim("username"));
        } catch (JWTVerificationException e) {
            System.err.println("token已过期");
//            throw new RuntimeException(e);
        }

    }

}
