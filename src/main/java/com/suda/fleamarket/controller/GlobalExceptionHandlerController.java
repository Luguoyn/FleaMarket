package com.suda.fleamarket.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.exception.FMException;
import com.suda.fleamarket.exception.PasswordIncorrectException;
import com.suda.fleamarket.http.ResultBody;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandlerController {

    /**
     * token验证异常
     */
    @ExceptionHandler(JWTVerificationException.class)
    public ResultBody jwtVerificationExceptionHandler(HttpServletRequest request, JWTVerificationException e) {
        return ResultBody.error(StatusCode.NOT_LOGGED_IN).setMessage("token失效");
    }

    /**
     * 数据校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultBody methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        List<String> list = new LinkedList<>();
        e.getBindingResult().getFieldErrors().forEach(err->list.add(err.getDefaultMessage()));
        return ResultBody.error(StatusCode.BODY_NOT_MATCH).setData(list);
    }

    @ExceptionHandler(FMException.class)
    public ResultBody passwordIncorrectExceptionHandler(HttpServletRequest request, FMException e) {
        return ResultBody.error().setCode(e.getErrorCode()).setMessage(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultBody exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return ResultBody.error(StatusCode.INTERNAL_SERVER_ERROR);
    }


}
