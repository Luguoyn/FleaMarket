package com.suda.fleamarket.service;

import com.suda.fleamarket.entity.Goods;

import java.util.List;

public interface AdminService {

    List<Goods> listByUserIdAndNotApprovedWithPage(Long userId, long pageIndex, long pageSize);

    List<Goods> listAllNotApprovedWithPage(long pageIndex, long pageSize);

    long getTotalPageCountByUserIdAndNotApproved(Long userId, long pageSize);

    long getTotalPageCountNotApproved(long pageSize);

    List<Goods> listAllNotApproved();

    List<Goods> listByUserIdAndNotApproved(Long userId);

    //TODO 添加修改用户权限的功能
    //TODO 添加审核商品的功能

}
