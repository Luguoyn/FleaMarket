package com.suda.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_order
 */
@TableName(value ="t_order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    /**
     * 订单表的id
     */
    @TableId
    private Long id;

    /**
     * 买家的id
     */
    private Long userId;

    /**
     * 购买的商品的id
     */
    private Long goodId;

    /**
     * 订单创建的时间
     */
    private Date createTime;

    /**
     * 购买商品的数量
     */
    private Integer amount;

    /**
     * 下单时的价格
     */
    private BigDecimal price;

    /**
     * 是否交易成功, 成功为1, 未成功为0
     */
    private Integer isFinished;

    /**
     * 是否被逻辑删除, 0为否, 1为是
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}