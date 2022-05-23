package com.suda.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "商品id不能为空")
    private Long id;

    /**
     * 发布者的id
     */
    @NotBlank(message = "商品发布者id不能为空")
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
    private Integer remainingQuantity;

    /**
     * 商品的价格
     */
    private BigDecimal price;

    /**
     * 商品图片的url
     */
    private String picture;

    /**
     * 商品的描述
     */
    private String describe;

    /**
     * 是否已审核, 0为否, 1为是
     */
    private Integer isApproved;

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