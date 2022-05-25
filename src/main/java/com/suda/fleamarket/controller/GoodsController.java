package com.suda.fleamarket.controller;

import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.GoodsService;
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

    @PostMapping("/all")
    public ResultBody getAllGoods() {
        return ResultBody.success().setData(goodsService.listByApproved());
    }

    @PostMapping("/u/{userId}")
    public ResultBody getAllGoodsFromUser(@PathVariable Long userId) {
        return ResultBody.success().setData(goodsService.listByUserIdAndApproved(userId));
    }

    @PostMapping("/u")
    public ResultBody getAllGoodsFromUser(HttpServletRequest request) {
        return ResultBody.success().setData(goodsService.listByUserId(JWTUtils.getUserIdFromToken(request.getHeader("token"))));
    }

    @PostMapping("/publish")
    public ResultBody publishGoods(HttpServletRequest request, @RequestBody @Valid Goods goods) {
        goods.setId(null);
        goods.setUserId(JWTUtils.getUserIdFromToken(request.getHeader("token")));
        return ResultBody.success().setData(goodsService.save(goods));
    }
}
