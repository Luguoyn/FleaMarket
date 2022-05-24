package com.suda.fleamarket.interceptors;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.suda.fleamarket.exception.PasswordIncorrectException;
import com.suda.fleamarket.exception.TokenNotExistException;
import com.suda.fleamarket.service.SecurityService;
import com.suda.fleamarket.utils.JWTUtils;
import com.suda.fleamarket.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    SecurityService securityService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if (token == null) {
            throw new TokenNotExistException("未登录");
        }
        DecodedJWT decodedJWT = JWTUtils.verifyToken(token);
        // 判断密码是否被修改
        if (!Arrays.equals(MD5Utils.md5WithSalt(decodedJWT.getClaim("password").asString()),
                MD5Utils.md5WithSalt(securityService.getById(decodedJWT.getClaim("userId").asLong()).getPassword()))) {
            throw new PasswordIncorrectException("密码已被修改, token失效");

        }
        return true;
    }
}
