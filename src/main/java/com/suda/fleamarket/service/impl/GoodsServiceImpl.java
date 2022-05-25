package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.service.GoodsService;
import com.suda.fleamarket.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 32488
 * @description 针对表【goods】的数据库操作Service实现
 * @createDate 2022-05-23 19:00:50
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
        implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> listByUserId(Long userId) {
        return goodsMapper.getAllByUserId(userId);
    }

    @Override
    public List<Goods> listByUserIdAndApproved(Long userId) {
        return goodsMapper.getAllByUserIdAndIsApproved(userId, 1);
    }

    @Override
    public List<Goods> listByApproved() {
        return goodsMapper.getAllByIsApproved(1);
    }
}




