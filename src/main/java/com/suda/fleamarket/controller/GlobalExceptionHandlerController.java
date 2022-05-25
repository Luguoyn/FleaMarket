package com.suda.fleamarket.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.suda.fleamarket.exception.FMException;
import com.suda.fleamarket.http.ResultBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JWTVerificationException.class)
    public ResultBody jwtVerificationExceptionHandler(HttpServletRequest request, JWTVerificationException e) {
        return ResultBody.error(HttpStatus.UNAUTHORIZED).setMessage("token失效");
    }

    /**
     * 请求异常
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultBody httpRequestMethodNotSupportedExceptionHandler(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        return ResultBody.error(HttpStatus.BAD_REQUEST).setMessage("请求有误");
    }

    /**
     * 数据校验异常
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultBody methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        List<String> list = new LinkedList<>();
        e.getBindingResult().getFieldErrors().forEach(err -> list.add(err.getDefaultMessage()));
        return ResultBody.error(HttpStatus.BAD_REQUEST).setData(list);
    }

    /**
     * 项目自定义异常
     */
    @ExceptionHandler(FMException.class)
    public ResponseEntity<ResultBody> fmExceptionHandler(HttpServletRequest request, FMException e) {
        return new ResponseEntity<>(ResultBody.error().setCode(e.getStatus().value()).setMessage(e.getMessage()), e.getStatus());
    }

    /**
     * 其他异常
     */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultBody exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return ResultBody.error(HttpStatus.INTERNAL_SERVER_ERROR).setData(e.getClass());
    }


}
