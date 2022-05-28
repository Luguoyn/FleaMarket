package com.suda.fleamarket.anno;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class CurrentUserIdHandlerMethodArgResolver implements HandlerMethodArgumentResolver {

    /**
     * 判断是否支持使用@CurrentUserId注解
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 如果该参数带有@CurrentUserId注解且参数类型是Long
        return parameter.getParameterAnnotation(CurrentUserId.class) != null && parameter.getParameterType() == Long.class;
    }

    /**
     * 注入UserID参数
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        return Long.parseLong((String) request.getSession().getAttribute("userId"));
    }
}
