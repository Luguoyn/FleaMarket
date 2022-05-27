package com.suda.fleamarket.controller;

import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.AdminService;
import com.suda.fleamarket.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/list-n")
    public ResultBody getAllGoodsNotApproved() {
        return ResultBody.success().setData(adminService.listAllNotApproved());
    }

    @PostMapping("/list-u/{userId}")
    public ResultBody getGoodsByUserIdAndNotApproved(@PathVariable Long userId) {
        return ResultBody.success().setData(adminService.listByUserIdAndNotApproved(userId));
    }

    @PostMapping("/list-n/p/{index}")
    public ResultBody getGoodsWithPage(@PathVariable Long index) {
        return ResultBody.success().setData(adminService.listAllNotApprovedWithPage(index, DataUtils.PAGE_SIZE));
    }

    @PostMapping("/list-u/{userId}/p/{index}")
    public ResultBody getGoodsByUserIdAndNotApprovedWithPage(@PathVariable Long userId, @PathVariable long index) {
        return ResultBody.success().setData(adminService.listByUserIdAndNotApprovedWithPage(userId, index, DataUtils.PAGE_SIZE));
    }
}
