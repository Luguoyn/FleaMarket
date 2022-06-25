package com.suda.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.enums.Gander;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId
    @NotNull(message = "id不能为空")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String name;

    /**
     *  用户的权限, 用数字代替, 默认为最低权限
     */
    private Authority authority;

    /**
     * 用户的生日
     */
    @Past(message = "生日有误")
    private Date birthday;

    /**
     * 用户的性别, 0为女, 1位男
     */
    private Gander gander;

    /**
     * 用户的地址
     */
    private String address;

    /**
     * 用户的电话
     */
    @Pattern(regexp = "^((13\\d)|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$",
            message = "错误的手机号码格式")
    private String telephone;

    /**
     * 用户的邮箱
     */
    @Email(message = "错误的邮箱格式")
    private String email;

    /**
     * 是否被逻辑删除, 0为否, 1为是
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}