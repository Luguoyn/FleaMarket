package com.suda.fleamarket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suda.fleamarket.entity.Security;
import com.suda.fleamarket.service.SecurityService;
import com.suda.fleamarket.mapper.SecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 32488
 * @description 针对表【security】的数据库操作Service实现
 * @createDate 2022-05-23 18:58:09
 */
@Service
public class SecurityServiceImpl extends ServiceImpl<SecurityMapper, Security>
        implements SecurityService {
    @Autowired
    SecurityMapper securityMapper;
}




