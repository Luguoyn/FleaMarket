package com.suda.fleamarket.controller;

import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    @PostMapping("/login")
    public ResultBody login() {
        return null;
    }

    @PostMapping("/register")
    public ResultBody register() {
        return null;
    }

}
