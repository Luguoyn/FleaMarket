package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.mapper.GoodsMapper;
import com.suda.fleamarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> listByUserIdAndNotApprovedWithPage(Long userId, long pageIndex, long pageSize) {
        Page<Goods> page = new Page<>(pageIndex, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
                .eq(Goods::getIsApproved, 1)
        );
        return page.getRecords();
    }

    @Override
    public List<Goods> listAllNotApprovedWithPage(long pageIndex, long pageSize) {
        Page<Goods> page = new Page<>(pageIndex, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getIsApproved, 1)
        );
        return page.getRecords();
    }

    @Override
    public long getTotalPageCountByUserIdAndNotApproved(Long userId, long pageSize) {
        Page<Goods> page = new Page<>(1, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
                .eq(Goods::getIsApproved, 0)
        );
        return page.getPages();
    }

    @Override
    public long getTotalPageCountNotApproved(long pageSize) {
        Page<Goods> page = new Page<>(1, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getIsApproved, 0)
        );
        return page.getPages();
    }

    @Override
    public List<Goods> listAllNotApproved() {
        return goodsMapper.selectList(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getIsApproved, 0)
        );
    }

    @Override
    public List<Goods> listByUserIdAndNotApproved(Long userId) {
        return goodsMapper.selectList(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
                .eq(Goods::getIsApproved, 0)
        );
    }

    @Override
    public List<Goods> listAll() {
        return goodsMapper.selectList(null);
    }
}
