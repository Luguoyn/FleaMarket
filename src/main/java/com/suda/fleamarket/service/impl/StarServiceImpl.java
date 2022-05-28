package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.entity.Star;
import com.suda.fleamarket.exception.status404.ResourcesNotFountException;
import com.suda.fleamarket.exception.status406.IllegalOperationException;
import com.suda.fleamarket.mapper.GoodsMapper;
import com.suda.fleamarket.service.StarService;
import com.suda.fleamarket.mapper.StarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        //取得关注的商品列表
        List<Long> goodsIdList = starMapper.selectList(new LambdaQueryWrapper<Star>()
                .select(Star::getGoodId)
                .eq(Star::getUserId, userId)
        ).stream().map(Star::getGoodId).collect(Collectors.toList());


        return goodsIdList.size() > 0 ?
                goodsMapper.selectList(new LambdaQueryWrapper<Goods>().in(Goods::getId, goodsIdList))
                : new ArrayList<>();

    }

    @Override
    public boolean save(Long userId, Long goodId) {
        if (goodsMapper.selectById(goodId) == null) {
            throw new ResourcesNotFountException("商品不存在");
        }

        if (starMapper.selectOne(new LambdaQueryWrapper<Star>()
                .eq(Star::getUserId, userId)
                .eq(Star::getGoodId, goodId)) != null) {
            throw new IllegalOperationException("已经收藏该商品了");
        }

        Star star = new Star();
        star.setUserId(userId);
        star.setGoodId(goodId);

        return starMapper.insert(star) == 1;
    }

    @Override
    public boolean remove(Long userId, Long goodId) {
        Star star = starMapper.selectOne(new LambdaQueryWrapper<Star>()
                .eq(Star::getUserId, userId)
                .eq(Star::getGoodId, goodId)
        );

        if (star == null) {
            throw new IllegalOperationException("您未收藏该商品");
        }

        return starMapper.deleteById(star) == 1;
    }


}




