package com.suda.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.enums.Gander;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     *  用户的权限, 用数字代替, 默认为最低权限
     */
    private Authority authority = Authority.NOT_CERTIFIED;

    /**
     * 用户的生日
     */
    private Date birthday;

    /**
     * 用户的性别, 0为女, 1位男
     */
    private Gander gander = Gander.FEMALE;

    /**
     * 用户的地址
     */
    private String address;

    /**
     * 用户的电话
     */
    private String telephone;

    /**
     * 用户的邮箱
     */
    private String email;

    /**
     * 是否被逻辑删除, 0为否, 1为是
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}