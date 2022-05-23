package com.suda.fleamarket.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Authority {
    NOT_CERTIFIED(0, "未认证"), // 未认证
    CUSTOMER(1, "可购买"),      // 顾客(仅可购买商品)
    SELLER(2, "可售卖"),        // 卖家(可发布商品)
    ADMIN(3, "管理员");         // 管理员(所有权限)

    @EnumValue
    private final int val;
    private final String text;
}

