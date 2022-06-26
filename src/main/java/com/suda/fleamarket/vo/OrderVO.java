package com.suda.fleamarket.vo;


import com.suda.fleamarket.entity.Goods;
import com.suda.fleamarket.entity.Order;
import com.suda.fleamarket.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {

    private Long orderId;
    private Long userId;
    private Long goodId;
    private Date createTime;
    private Integer amount;
    private BigDecimal price;
    private Integer isFinished;

    private Goods goods;

    private User user;

    public OrderVO(Order order, Goods goods, User user) {
        this.orderId = order.getId();
        this.userId = order.getUserId();
        this.goodId = order.getGoodId();
        this.createTime = order.getCreateTime();
        this.amount = order.getAmount();
        this.price = order.getPrice();
        this.isFinished = order.getIsFinished();

        this.goods = goods;
        this.user = user;
    }

    public static OrderVO getFromEntity(Order entity, Goods goods, User user) {
        return new OrderVO(entity, goods, user);
    }

    public Order toEntity() {
        return Order.builder()
                .id(orderId).userId(userId).goodId(goodId)
                .createTime(createTime).amount(amount)
                .price(price).isFinished(isFinished)
                .build();
    }
}
