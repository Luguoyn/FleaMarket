package com.suda.fleamarket.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.suda.fleamarket.enums.StatusCode;
import com.suda.fleamarket.exception.PasswordIncorrectException;
import com.suda.fleamarket.http.ResultBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler(SignatureVerificationException.class)
    public ResultBody signatureVerificationExceptionHandler(HttpServletRequest request, SignatureVerificationException e) {
        return ResultBody.error(StatusCode.FORBIDDEN).setMessage("签名无效");
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResultBody tokenExpiredExceptionHandler(HttpServletRequest request, TokenExpiredException e) {
        return ResultBody.error(StatusCode.FORBIDDEN).setMessage("token过期");
    }

    @ExceptionHandler(AlgorithmMismatchException.class)
    public ResultBody algorithmMismatchExceptionHandler(HttpServletRequest request, AlgorithmMismatchException e) {
        return ResultBody.error(StatusCode.FORBIDDEN).setMessage("算法无效");
    }

    @ExceptionHandler(PasswordIncorrectException.class)
    public ResultBody passwordIncorrectExceptionHandler(HttpServletRequest request, PasswordIncorrectException e) {
        return ResultBody.error().setCode(e.getErrorCode()).setMessage(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultBody exceptionHandler(HttpServletRequest request, Exception e) {
        return ResultBody.error(StatusCode.INTERNAL_SERVER_ERROR);
    }


}
