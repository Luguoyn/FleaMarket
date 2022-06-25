package com.suda.fleamarket.service;

import com.suda.fleamarket.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 32488
* @description 针对表【order】的数据库操作Service
* @createDate 2022-05-23 18:58:09
*/
public interface OrderService extends IService<Order> {
    boolean save(Long userId, Long goodId, Integer amount);

    boolean remove(Long userId, Long id);

    List<Order> listByUser(Long userId);

    List<Order> listByGoodId(Long userId, Long goodId);

    boolean confirm(Long userId, Long id);
}
