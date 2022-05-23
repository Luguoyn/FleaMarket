package com.suda.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName security
 */
@TableName(value ="security")
@Data
public class Security implements Serializable {
    /**
     * 密码表的id
     */
    @TableId
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * 密码, 需要用md5加密
     */
    private String password;

    /**
     * 是否被逻辑删除, 0为否, 1为是
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}