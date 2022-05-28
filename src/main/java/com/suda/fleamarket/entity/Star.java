package com.suda.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @TableName star
 */
@TableName(value = "star")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Star implements Serializable {
    /**
     * 收藏表的id
     */
    @TableId
    private Long id;

    /**
     * 收藏者的id
     */
    private Long userId;

    /**
     * 被收藏商品的id
     */
    @NotNull(message = "商品id不能为空")
    private Long goodId;

    /**
     * 是否被逻辑删除, 0为否, 1为是
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}