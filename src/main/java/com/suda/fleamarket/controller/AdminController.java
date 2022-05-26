package com.suda.fleamarket.controller;

import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/list-n")
    public ResultBody getAllGoodsNotApproved() {
        return ResultBody.success().setData(adminService.listAllNotApproved());
    }

    @PostMapping("/list-u/{userId}")
    public ResultBody getAllGoodsByUserIdAndNotApproved(@PathVariable Long userId){
        return ResultBody.success().setData(adminService.listByUserIdAndNotApproved(userId));
    }


}
