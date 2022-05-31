package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.entity.Order;
import com.suda.fleamarket.exception.FMException;
import com.suda.fleamarket.exception.status400.FMBadRequestException;
import com.suda.fleamarket.exception.status404.ResourcesNotFountException;
import com.suda.fleamarket.exception.status406.IllegalOperationException;
import com.suda.fleamarket.exception.status500.UnsuccessfulOperationException;
import com.suda.fleamarket.mapper.GoodsMapper;
import com.suda.fleamarket.service.OrderService;
import com.suda.fleamarket.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    @Transactional
    public boolean save(Long userId, Long goodId, Integer amount) {
        Goods goods = goodsMapper.selectById(goodId);
        if (goods == null) {
            throw new ResourcesNotFountException("商品不存在");
        }

        if (goods.getIsApproved() == 0) {
            throw new IllegalOperationException("商品未经过审核");
        }

        if (goods.getRemainingQuantity() < amount) {
            throw new FMBadRequestException("商品余量不足");
        }

        Order order = Order.builder()
                .userId(userId).goodId(goodId)
                .amount(amount).price(goods.getPrice())
                .build();

        if (orderMapper.insert(order) == 0) {
            throw new UnsuccessfulOperationException("订单创建失败");
        }

        goods.setRemainingQuantity(goods.getRemainingQuantity() - amount);
        if (goodsMapper.updateById(goods) == 0) {
            throw new UnsuccessfulOperationException("订单创建失败");
        }

        return true;
    }

    @Override
    @Transactional
    public boolean remove(Long userId, Long id) {
        Order order = orderMapper.selectById(id);

        if (order == null) {
            throw new ResourcesNotFountException("订单不存在");
        }

        if (!order.getUserId().equals(userId)) {
            throw new IllegalOperationException("只能删除自己的订单");
        }

        if (order.getIsFinished() > 0) {
            throw new IllegalOperationException("只能删除未完成的订单");
        }

        Goods goods = goodsMapper.selectById(order.getGoodId());
        if (goods == null) {
            throw new ResourcesNotFountException("商品不存在");
        }

        goods.setRemainingQuantity(goods.getRemainingQuantity() + order.getAmount());

        if (goodsMapper.updateById(goods) == 0) {
            throw new UnsuccessfulOperationException("订单删除失败");
        }

        if (orderMapper.deleteById(order) == 0) {
            throw new UnsuccessfulOperationException("订单删除失败");
        }

        return true;
    }

    @Override
    public List<Order> listByUser(Long userId) {
        return orderMapper.selectList(new LambdaQueryWrapper<Order>().eq(Order::getUserId, userId).orderByDesc(Order::getCreateTime));
    }

    @Override
    public boolean confirm(Long userId, Long id) {
        Order order = orderMapper.selectById(id);
        if (order == null) {
            throw new ResourcesNotFountException("订单不存在");
        }
        if (!order.getUserId().equals(userId)) {
            throw new IllegalOperationException("只能确认自己的订单");
        }

        order.setIsFinished(1);

        if (orderMapper.updateById(order) == 0) {
            throw new UnsuccessfulOperationException("订单确认失败");
        }

        return true;
    }
}




