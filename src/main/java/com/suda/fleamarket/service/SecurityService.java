package com.suda.fleamarket.service;

import com.suda.fleamarket.entity.Security;
import com.baomidou.mybatisplus.extension.service.IService;
import com.suda.fleamarket.entity.User;

/**
* @author 32488
* @description 针对表【security】的数据库操作Service
* @createDate 2022-05-23 18:58:09
*/
public interface SecurityService extends IService<Security> {
    Security login(String loginName, String password);

    Security register(String loginName, String password);

    Security updatePassword(Long id, String oldPassword, String newPassword);
}
