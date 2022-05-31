package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.dto.GoodsDTO;
import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.exception.status404.ResourcesNotFountException;
import com.suda.fleamarket.exception.status406.IllegalOperationException;
import com.suda.fleamarket.mapper.UserMapper;
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

    @Autowired
    UserMapper userMapper;

    @Override
    public List<Goods> listByUserId(Long userId) {
        return goodsMapper.selectList(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
        );
    }

    @Override
    public List<Goods> listByUserIdAndApproved(Long userId) {
        return goodsMapper.selectList(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
                .eq(Goods::getIsApproved, 1)
        );
    }

    @Override
    public List<Goods> listAllApproved() {
        return goodsMapper.selectList(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getIsApproved, 1)
        );
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

    @Override
    public List<Goods> listByUserIdAndNotApproved(Long userId) {
        return goodsMapper.selectList(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
                .eq(Goods::getIsApproved, 0)
        );
    }

    @Override
    public List<Goods> listByUserIdWithPage(Long userId, long pageIndex, long pageSize) {
        Page<Goods> page = new Page<>(1, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
        );
        return page.getRecords();
    }

    @Override
    public List<Goods> listByUserIdAndNotApprovedWithPage(Long userId, long pageIndex, long pageSize) {
        Page<Goods> page = new Page<>(pageIndex, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
                .eq(Goods::getIsApproved, 0)
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
    public long getTotalPageCountByUserId(Long userId, long pageSize) {
        Page<Goods> page = new Page<>(1, pageSize);
        goodsMapper.selectPage(page, new LambdaQueryWrapper<Goods>()
                .eq(Goods::getUserId, userId)
        );
        return page.getPages();
    }

    @Override
    public boolean removeByIdAndUserId(Long id, Long userId) {
        Goods goods = goodsMapper.selectById(id);

        if (goods == null) {
            throw new ResourcesNotFountException("待删除商品不存在");
        }

        if (!goods.getUserId().equals(userId)) {
            throw new IllegalOperationException("只能删除自己发布的商品");
        }

        return goodsMapper.deleteById(id) == 1;
    }

    @Override
    public boolean saveByUserId(Goods goods, Long userId) {
        Goods oldGoods = goodsMapper.selectById(goods.getId());

        if (oldGoods == null) {
            throw new ResourcesNotFountException("待修改商品不存在");
        }

        if (!oldGoods.getUserId().equals(userId)) {
            throw new IllegalOperationException("只能修改自己发布的商品");
        }

        goods.setUserId(userId);
        goods.setIsApproved(0);

        return goodsMapper.updateById(goods) == 1;
    }

    @Override
    public List<Goods> select(GoodsDTO goodsDTO) {
        return goodsMapper.selectList(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getIsApproved, 1)
                .like(goodsDTO.getName() != null, Goods::getName, goodsDTO.getName())
                .eq(goodsDTO.getUserId() != null, Goods::getUserId, goodsDTO.getUserId())
                .ge(goodsDTO.getMinPrice() != null, Goods::getPrice, goodsDTO.getMinPrice())
                .le(goodsDTO.getMaxPrice() != null, Goods::getPrice, goodsDTO.getMaxPrice())
        );
    }
}




