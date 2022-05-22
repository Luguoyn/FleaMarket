package com.suda.fleamarket.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Authority {
    NOT_CERTIFIED(0), // 未认证
    CUSTOMER(1),      // 顾客(仅可购买商品)
    SELLER(2),        // 卖家(可发布商品)
    ADMIN(3);         // 管理员(所有权限)

    private final int ordinal;

    public static Authority get(int val) {
        for (Authority authority : Authority.values()) {
            if (authority.ordinal == val) {
                return authority;
            }
        }
        return null;
    }
}
