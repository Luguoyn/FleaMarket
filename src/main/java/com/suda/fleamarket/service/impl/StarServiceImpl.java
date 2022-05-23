package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.Star;
import com.suda.fleamarket.service.StarService;
import com.suda.fleamarket.mapper.StarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}



