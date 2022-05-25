package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public List<Goods> listAllApproved() {
        return goodsMapper.getAllByIsApproved(1);
    }

    @Override
    public List<Goods> listByUserIdAndApprovedWithPage(Long userId, long pageIndex, long pageSize) {
        Page<Goods> page = new Page<>(pageIndex, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
                .eq(Goods::getIsApproved, 1)
        );
        return page.getRecords();
    }

    @Override
    public List<Goods> listAllApprovedWithPage(long pageIndex, long pageSize) {
        Page<Goods> page = new Page<>(pageIndex, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getIsApproved, 1)
        );
        return page.getRecords();
    }

    @Override
    public long getTotalPageCountByUserIdAndApproved(Long userId, long pageSize) {
        Page<Goods> page = new Page<>(1, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
                .eq(Goods::getIsApproved, 1)
        );
        return page.getPages();
    }

    @Override
    public long getTotalPageCountApproved(long pageSize) {
        Page<Goods> page = new Page<>(1, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getIsApproved, 1)
        );
        return page.getPages();
    }
}




