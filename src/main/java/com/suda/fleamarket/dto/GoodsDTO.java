package com.suda.fleamarket.dto;

import com.suda.fleamarket.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsDTO implements FMDTO<Goods> {

    private Long goodId;

    private Long userId;

    private String name;
    private Date releaseTime;

    @Positive(message = "余量必须为正")
    private Integer remainingQuantity;

    private BigDecimal price;
    private String picture;
    private String description = "暂无描述";
    private Integer isApproved = 0;

    private String type;

    private BigDecimal maxPrice;
    private BigDecimal minPrice;

    public GoodsDTO(Goods goods) {
        this.goodId = goods.getId();
        this.userId = goods.getUserId();
        this.name = goods.getName();
        this.isApproved = goods.getIsApproved();
        this.description = goods.getDescription();
        this.price = goods.getPrice();
        this.picture = goods.getPicture();
        this.releaseTime = goods.getReleaseTime();
        this.remainingQuantity = goods.getRemainingQuantity();
        this.type = goods.getType();
    }

    public static GoodsDTO getFromEntity(Goods entity) {
        return new GoodsDTO(entity);
    }

    @Override
    public Goods toEntity() {
        return Goods.builder()
                .id(goodId).userId(userId).description(description).type(type)
                .isApproved(isApproved).name(name).picture(picture).price(price)
                .releaseTime(releaseTime).remainingQuantity(remainingQuantity)
                .build();
    }
}
