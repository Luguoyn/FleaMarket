package com.suda.fleamarket.interceptors;

import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.exception.status406.IllegalOperationException;
import com.suda.fleamarket.service.UserService;
import com.suda.fleamarket.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityInterceptor implements HandlerInterceptor {
    private final Authority authority;

    @Autowired
    UserService userService;

    public AuthorityInterceptor(Authority authority) {
        this.authority = authority;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println(authority.getText());

        if(userService.getById(JWTUtils.getUserIdFromToken(request.getHeader("token"))).getAuthority().getVal() >= authority.getVal()){
            return true;
        }

        throw new IllegalOperationException("权限不足");
    }
}
