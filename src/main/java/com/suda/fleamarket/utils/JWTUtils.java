package com.suda.fleamarket.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.suda.fleamarket.entity.Security;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String SING = "i%#fo1s2h8F&YU@h472%#%@d81sdg35sf45y2$huw&*F*YRR*@&%$YHsf";

    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 15);

        JWTCreator.Builder builder = JWT.create();

        //设置payload
        map.forEach(builder::withClaim);

        return builder.withExpiresAt(instance.getTime()) // 设置token过期时间
                .sign(Algorithm.HMAC256(SING));
    }

    public static DecodedJWT verifyToken(String token){
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }

    public static String getToken(Security security){
        Map<String, String> payload = new HashMap<>();
        payload.put("id", security.getId().toString());
        payload.put("userId", security.getUserId().toString());
        payload.put("password", security.getPassword());
        return JWTUtils.getToken(payload);
    }

}
