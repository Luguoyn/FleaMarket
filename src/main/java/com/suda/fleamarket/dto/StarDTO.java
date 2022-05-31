package com.suda.fleamarket.dto;

import com.suda.fleamarket.entity.Star;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StarDTO implements FMDTO<Star> {
    private Long starId;
    private Long goodId;
    private Long userId;

    public StarDTO(Star star) {
        this.starId = star.getId();
        this.userId = star.getUserId();
        this.goodId = star.getGoodId();
    }

    public static StarDTO getFromEntity(Star entity) {
        return new StarDTO(entity);
    }

    @Override
    public Star toEntity() {
        return Star.builder().goodId(goodId).userId(userId).id(starId).build();
    }
}
