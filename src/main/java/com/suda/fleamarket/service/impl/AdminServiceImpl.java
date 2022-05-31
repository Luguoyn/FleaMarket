package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.exception.status404.ResourcesNotFountException;
import com.suda.fleamarket.exception.status406.IllegalOperationException;
import com.suda.fleamarket.mapper.GoodsMapper;
import com.suda.fleamarket.mapper.UserMapper;
import com.suda.fleamarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMapper userMapper;

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
    public boolean setApproved(Long goodId, boolean isApproved) {
        Goods goods = goodsMapper.selectById(goodId);
        if (goods == null) {
            throw new ResourcesNotFountException("待审核商品不存在");
        }

        goods.setIsApproved(isApproved ? 1 : 0);

        return goodsMapper.update(goods, new LambdaQueryWrapper<Goods>().eq(Goods::getId, goodId)) == 1;
    }

    @Override
    public boolean setAuthority(Long userId, Authority authority) {
        if (authority == Authority.ADMIN) {
            throw new IllegalOperationException("不能将他人设为管理员");
        }

        User user = userMapper.selectById(userId);

        if (user == null) {
            throw new ResourcesNotFountException("用户不存在");
        }

        user.setAuthority(authority);
        return userMapper.updateById(user) == 1;
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

}
