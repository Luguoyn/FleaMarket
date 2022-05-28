package com.suda.fleamarket.controller;

import com.suda.fleamarket.anno.CurrentUserId;
import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.exception.status404.ResourcesNotFountException;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.GoodsService;
import com.suda.fleamarket.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultBody getGoodsInfo(@PathVariable Long id) {
        Goods goods = goodsService.getById(id);
        if (goods == null) {
            throw new ResourcesNotFountException("货物不存在");
        }
        return ResultBody.success().setData(goods);
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
    public ResultBody getAllGoodsFromUser(@CurrentUserId Long currentUserId) {
        return ResultBody.success().setData(goodsService.listByUserId(currentUserId));
    }

    /**
     * 给出某人的货物信息
     */
    @PostMapping("/list-u/{userId}")
    public ResultBody getAllGoodsFromUser(@CurrentUserId Long currentUserId, @PathVariable Long userId) {
        if (currentUserId.equals(userId))
            return getAllGoodsFromUser(currentUserId);
        else
            return ResultBody.success().setData(goodsService.listByUserIdAndApproved(userId));
    }

    /**
     * 给出某人的某页的货物信息
     */
    @PostMapping("/list-u/{userId}/p/{index}")
    public ResultBody getAllGoodsFromUserWithPage(@CurrentUserId Long currentUserId, @PathVariable Long userId, @PathVariable long index) {
        if (currentUserId.equals(userId))
            return ResultBody.success().setData(goodsService.listByUserIdWithPage(userId, index, DataUtils.PAGE_SIZE));
        else
            return ResultBody.success().setData(goodsService.listByUserIdAndApprovedWithPage(userId, index, DataUtils.PAGE_SIZE));
    }

    /**
     * 发布货物
     */
    @PostMapping("/publish")
    public ResultBody publishGoods(@CurrentUserId Long currentUserId, @RequestBody @Valid Goods goods) {
        goods.setId(null);
        goods.setIsApproved(0);
        goods.setUserId(currentUserId);
        goods.setIsDeleted(0);
        return ResultBody.success().setData(goodsService.save(goods));
    }

    /**
     * 删除货物
     */
    @PostMapping("/delete/{id}")
    public ResultBody deleteGoods(@CurrentUserId Long currentUserId, @PathVariable Long id) {
        return ResultBody.success().setData(goodsService.removeByIdAndUserId(id, currentUserId));
    }

    /**
     * 修改货物信息
     */
    @PostMapping("/update")
    public ResultBody updateGoods(@CurrentUserId Long currentUserId, @RequestBody @Valid Goods goods) {
        return ResultBody.success().setData(goodsService.saveByUserId(goods, currentUserId));
    }
}
