package com.suda.fleamarket.dto;


import com.suda.fleamarket.entity.Order;
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
public class OrderDTO implements FMDTO<Order> {

    private Long id;
    private Long userId;
    private Long goodId;
    private Date createTime;
    private Integer amount;
    private BigDecimal price;
    private Integer isFinished;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.userId = order.getUserId();
        this.goodId = order.getGoodId();
        this.createTime = order.getCreateTime();
        this.amount = order.getAmount();
        this.price = order.getPrice();
        this.isFinished = order.getIsFinished();
    }

    public static OrderDTO getFromEntity(Order entity){
        return new OrderDTO(entity);
    }

    @Override
    public Order toEntity() {
        return Order.builder()
                .id(id).userId(userId).goodId(goodId)
                .createTime(createTime).amount(amount)
                .price(price).isFinished(isFinished)
                .build();
    }
}
