package com.suda.fleamarket.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.suda.fleamarket.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 32488
* @description 针对表【goods】的数据库操作Mapper
* @createDate 2022-05-23 19:00:50
* @Entity com.suda.fleamarket.entity.Goods
*/

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}




