package com.suda.fleamarket.mapper;

import com.suda.fleamarket.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 32488
* @description 针对表【order】的数据库操作Mapper
* @createDate 2022-05-23 18:58:09
* @Entity com.suda.fleamarket.entity.Order
*/

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}




