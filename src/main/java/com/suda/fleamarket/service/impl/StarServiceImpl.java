package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.entity.Star;
import com.suda.fleamarket.mapper.GoodsMapper;
import com.suda.fleamarket.service.StarService;
import com.suda.fleamarket.mapper.StarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 32488
 * @description 针对表【star】的数据库操作Service实现
 * @createDate 2022-05-23 18:58:09
 */
@Service
public class StarServiceImpl extends ServiceImpl<StarMapper, Star>
        implements StarService {
    @Autowired
    StarMapper starMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> listAllByUserId(Long userId) {
        List<Long> goodIdList = new LinkedList<>();
        starMapper.selectList(
                new LambdaQueryWrapper<Star>()
                        .select(Star::getGoodId)
                        .eq(Star::getUserId, userId)
        ).forEach(star -> goodIdList.add(star.getUserId()));
        return goodsMapper.selectList(new LambdaQueryWrapper<Goods>().in(Goods::getId, goodIdList));
    }

    @Override
    public boolean save(Long userId, Long goodId) {
        return false;
    }

    @Override
    public boolean remove(Long userId, Long goodId) {
        return false;
    }


}




