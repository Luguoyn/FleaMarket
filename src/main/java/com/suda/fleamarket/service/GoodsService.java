package com.suda.fleamarket.service;

import com.suda.fleamarket.dto.GoodsDTO;
import com.suda.fleamarket.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 32488
 * @description 针对表【goods】的数据库操作Service
 * @createDate 2022-05-23 19:00:50
 */
public interface GoodsService extends IService<Goods> {
    List<Goods> listByUserId(Long userId);

    List<Goods> listByUserIdAndApproved(Long userId);

    List<Goods> listAllApproved();

    List<Goods> listByUserIdAndApprovedWithPage(Long userId, long pageIndex, long pageSize);

    List<Goods> listAllApprovedWithPage(long pageIndex, long pageSize);

    long getTotalPageCountByUserIdAndApproved(Long userId, long pageSize);

    long getTotalPageCountApproved(long pageSize);

    List<Goods> listByUserIdAndNotApproved(Long userId);

    List<Goods> listByUserIdWithPage(Long userId, long pageIndex, long pageSize);

    List<Goods> listByUserIdAndNotApprovedWithPage(Long userId, long pageIndex, long pageSize);

    long getTotalPageCountByUserIdAndNotApproved(Long userId, long pageSize);

    long getTotalPageCountByUserId(Long userId, long pageSize);

    boolean removeByIdAndUserId(Long id, Long userId);

    boolean saveByUserId(Goods goods, Long userId);

    List<Goods> select(GoodsDTO goodsDTO);
}
