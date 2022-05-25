package com.suda.fleamarket.controller;

import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.GoodsService;
import com.suda.fleamarket.utils.DataUtils;
import com.suda.fleamarket.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /**
     * 列出所有已审核的货物
     */
    @PostMapping("/list")
    public ResultBody getAllGoods() {
        return ResultBody.success().setData(goodsService.listAllApproved());
    }

    /**
     * 给出单个货物信息
     */
    @PostMapping("/info/{id}")
    public ResultBody getGoodsInfo(@PathVariable long id) {
        return ResultBody.success().setData(goodsService.getById(id));
    }

    /**
     * 给出某一页的货物信息
     */
    @PostMapping("/list/p/{index}")
    public ResultBody getGoodsWithPage(@PathVariable long index) {
        return ResultBody.success().setData(goodsService.listAllApprovedWithPage(index, DataUtils.PAGE_SIZE));
    }

    /**
     * 给出当前登录用户的货物信息，包括未审核的货物
     */
    @PostMapping("/list-u")
    public ResultBody getAllGoodsFromUser(HttpServletRequest request) {
        return ResultBody.success().setData(goodsService.listByUserId(JWTUtils.getUserIdFromToken(request.getHeader("token"))));
    }

    /**
     * 给出某人的货物信息
     */
    @PostMapping("/list-u/{userId}")
    public ResultBody getAllGoodsFromUser(HttpServletRequest request, @PathVariable Long userId) {
        if (JWTUtils.getUserIdFromToken(request.getHeader("token")).equals(userId))
            return ResultBody.success().setData(goodsService.listByUserId(userId));
        else
            return ResultBody.success().setData(goodsService.listByUserIdAndApproved(userId));
    }

    /**
     * 给出某人的某页的货物信息
     */
    @PostMapping("/list-u/{userId}/p/{index}")
    public ResultBody getAllGoodsFromUserWithPage(HttpServletRequest request, @PathVariable Long userId, @PathVariable long index) {
        if (JWTUtils.getUserIdFromToken(request.getHeader("token")).equals(userId))
            return ResultBody.success().setData(goodsService.listByUserIdWithPage(userId, index, DataUtils.PAGE_SIZE));
        else
            return ResultBody.success().setData(goodsService.listByUserIdAndApprovedWithPage(userId, index, DataUtils.PAGE_SIZE));
    }

    /**
     * 发布货物
     */
    @PostMapping("/publish")
    public ResultBody publishGoods(HttpServletRequest request, @RequestBody @Valid Goods goods) {
        goods.setId(null);
        goods.setUserId(JWTUtils.getUserIdFromToken(request.getHeader("token")));
        return ResultBody.success().setData(goodsService.save(goods));
    }

    /**
     * 删除货物
     */
    @PostMapping("/delete/{id}")
    public ResultBody deleteGoods(HttpServletRequest request, @PathVariable Long id) {
        return ResultBody.success().setData(goodsService.removeByIdAndUserId(id, JWTUtils.getUserIdFromToken(request.getHeader("token"))));
    }
}
