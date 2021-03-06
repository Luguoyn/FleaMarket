package com.suda.fleamarket.controller;

import com.suda.fleamarket.dto.UserDTO;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.AdminService;
import com.suda.fleamarket.service.GoodsService;
import com.suda.fleamarket.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    GoodsService goodsService;

    @PostMapping("/list-n")
    public ResultBody getAllGoodsNotApproved() {
        return ResultBody.success().setData(adminService.listAllNotApproved());
    }

    @PostMapping("/list-u/{userId}")
    public ResultBody getGoodsByUserIdAndNotApproved(@PathVariable Long userId) {
        return ResultBody.success().setData(goodsService.listByUserIdAndNotApproved(userId));
    }

    @PostMapping("/list-n/p/{index}")
    public ResultBody getGoodsWithPage(@PathVariable Long index) {
        return ResultBody.success().setData(adminService.listAllNotApprovedWithPage(index, DataUtils.PAGE_SIZE));
    }

    @PostMapping("/list-u/{userId}/p/{index}")
    public ResultBody getGoodsByUserIdAndNotApprovedWithPage(@PathVariable Long userId, @PathVariable long index) {
        return ResultBody.success().setData(goodsService.listByUserIdAndNotApprovedWithPage(userId, index, DataUtils.PAGE_SIZE));
    }

    @PostMapping("/approve/{goodId}")
    public ResultBody approve(@PathVariable Long goodId) {
        return ResultBody.success().setData(adminService.setApproved(goodId, true));
    }

    @PostMapping("/anti-approve/{goodId}")
    public ResultBody antiApprove(@PathVariable Long goodId) {
        return ResultBody.success().setData(adminService.setApproved(goodId, false));
    }

    @PostMapping("/authority")
    public ResultBody authority(@RequestBody UserDTO userDTO) {
        return ResultBody.success().setData(adminService.setAuthority(userDTO.getUserId(), userDTO.getAuthority()));
    }
}
