package com.suda.fleamarket.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.suda.fleamarket.entity.Security;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 32488
* @description 针对表【security】的数据库操作Mapper
* @createDate 2022-05-23 18:58:09
* @Entity com.suda.fleamarket.entity.Security
*/

@Mapper
public interface SecurityMapper extends BaseMapper<Security> {
    default Security selectOneByLoginName(String loginName){
        return selectOne(new LambdaQueryWrapper<Security>().eq(Security::getLoginName, loginName));
    }
    default Security selectOneByUserId(Long userId){
        return selectOne(new LambdaQueryWrapper<Security>().eq(Security::getUserId, userId));
    }

}




