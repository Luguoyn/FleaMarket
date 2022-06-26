package com.suda.fleamarket.controller;

import com.suda.fleamarket.anno.CurrentUserId;
import com.suda.fleamarket.dto.OrderDTO;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.GoodsService;
import com.suda.fleamarket.service.OrderService;
import com.suda.fleamarket.service.UserService;
import com.suda.fleamarket.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    GoodsService goodsService;

    @Autowired
    UserService userService;

    @PostMapping("/list")
    public ResultBody list(@CurrentUserId Long currentUserId) {
        return ResultBody.success().setData(orderService.listByUser(currentUserId)
                .stream()
                .map(o -> OrderVO.getFromEntity(o, goodsService.getById(o.getGoodId()), userService.getById(o.getUserId())))
                .collect(Collectors.toList()));
    }

    @PostMapping("/list-by-goods")
    public ResultBody list(@CurrentUserId Long currentUserId, @RequestBody OrderDTO orderDTO) {
        return ResultBody.success().setData(orderService.listByGoodId(currentUserId, orderDTO.getGoodId())
                .stream()
                .map(o -> OrderVO.getFromEntity(o, goodsService.getById(o.getGoodId()), userService.getById(o.getUserId())))
                .collect(Collectors.toList()));
    }

    @PostMapping("/place")
    public ResultBody place(@CurrentUserId Long currentUserId, @RequestBody OrderDTO orderDTO) {
        return ResultBody.success().setData(orderService.save(currentUserId, orderDTO.getGoodId(), orderDTO.getAmount()));
    }

    @PostMapping("/cancel")
    public ResultBody cancel(@CurrentUserId Long currentUserId, @RequestBody OrderDTO orderDTO) {
        return ResultBody.success().setData(orderService.remove(currentUserId, orderDTO.getOrderId()));
    }

    @PostMapping("/confirm")
    public ResultBody confirm(@CurrentUserId Long currentUserId, @RequestBody OrderDTO orderDTO) {
        return ResultBody.success().setData(orderService.confirm(currentUserId, orderDTO.getOrderId()));
    }
}
