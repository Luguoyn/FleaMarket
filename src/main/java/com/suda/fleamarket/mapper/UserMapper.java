package com.suda.fleamarket.mapper;
import org.apache.ibatis.annotations.Param;

import com.suda.fleamarket.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 32488
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-05-23 19:02:25
* @Entity com.suda.fleamarket.entity.User
*/

@Mapper
public interface UserMapper extends BaseMapper<User> {

}




