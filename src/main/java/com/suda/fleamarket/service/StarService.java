package com.suda.fleamarket.service;

import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.entity.Star;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 32488
* @description 针对表【star】的数据库操作Service
* @createDate 2022-05-23 18:58:09
*/
public interface StarService extends IService<Star> {
    List<Goods> listAllByUserId(Long userId);

    boolean save(Long userId, Long goodId);

    boolean remove(Long userId, Long goodId);

}
