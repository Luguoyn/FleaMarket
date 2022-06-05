package com.suda.fleamarket.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class InterceptorAspect {
    @Pointcut("execution(public * com.suda.fleamarket.interceptors.*.preHandle(..))")
    private void preHandle() {
    }


    @Around("preHandle()")
    public boolean hehehe(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];

        // 解决某些浏览器为了请求跨域发送OPTIONS请求的问题
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }

        System.out.println(joinPoint.proceed(joinPoint.getArgs()));
        return true ;
    }

}
