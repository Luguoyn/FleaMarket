package com.suda.fleamarket.service;

import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.enums.Authority;

import java.util.List;

public interface AdminService {

    List<Goods> listAllNotApprovedWithPage(long pageIndex, long pageSize);


    long getTotalPageCountNotApproved(long pageSize);

    List<Goods> listAllNotApproved();


    List<Goods> listByUserIdAndNotApprovedWithPage(Long userId, long pageIndex, long pageSize);

    boolean setApproved(Long goodId, boolean isApproved);

    boolean setAuthority(Long userId, Authority authority);
}
