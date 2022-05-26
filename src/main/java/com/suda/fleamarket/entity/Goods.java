package com.suda.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * 
 * @TableName goods
 */
@TableName(value ="goods")
@Data
public class Goods implements Serializable {
    /**
     * 商品的id
     */
    @TableId
    private Long id;

    /**
     * 发布者的id
     */
    private Long userId;

    /**
     * 商品的名称
     */
    @NotBlank(message = "商品名称不能为空")
    private String name;

    /**
     * 商品发布的时间
     */
    private Date releaseTime;

    /**
     * 商品的余量
     */
    @NotNull(message = "商品的余量不能为空")
    @Positive(message = "余量必须为正")
    private Integer remainingQuantity;

    /**
     * 商品的价格
     */
    @NotNull(message = "商品的价格不能为空")
    private BigDecimal price;

    /**
     * 商品图片的url
     */
    private String picture;

    /**
     * 商品的描述
     */
    private String description = "暂无描述";

    /**
     * 是否已审核, 0为否, 1为是
     */
    private Integer isApproved = 0;

    /**
     * 是否被逻辑删除, 0为否, 1为是
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 版本号
     */
    @Version
    private Integer version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}