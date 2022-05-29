package com.suda.fleamarket.service;

import com.suda.fleamarket.entity.Goods;

import java.util.List;

public interface AdminService {

    List<Goods> listAllNotApprovedWithPage(long pageIndex, long pageSize);


    long getTotalPageCountNotApproved(long pageSize);

    List<Goods> listAllNotApproved();


    List<Goods> listByUserIdAndNotApprovedWithPage(Long userId, long pageIndex, long pageSize);

    boolean setApproved(Long goodId, boolean isApproved);

    //TODO 添加修改用户权限的功能
}
