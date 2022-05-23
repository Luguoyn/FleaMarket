package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.Order;
import com.suda.fleamarket.service.OrderService;
import com.suda.fleamarket.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 32488
 * @description 针对表【order】的数据库操作Service实现
 * @createDate 2022-05-23 18:58:09
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {
    @Autowired
    OrderMapper orderMapper;
}




