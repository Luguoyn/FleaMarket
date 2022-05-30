package com.suda.fleamarket.service;

import com.suda.fleamarket.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 32488
* @description 针对表【user】的数据库操作Service
* @createDate 2022-05-23 19:02:25
*/
public interface UserService extends IService<User> {
    User createNewUser(User user);

    User createNewUser();

    boolean updateUser(User user);


}
