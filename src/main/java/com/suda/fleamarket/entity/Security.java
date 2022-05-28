package com.suda.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * 
 * @TableName security
 */
@TableName(value ="security")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @NotBlank(message = "用户名不能为空")
    private String loginName;

    /**
     * 密码, 需要用md5加密
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 是否被逻辑删除, 0为否, 1为是
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}