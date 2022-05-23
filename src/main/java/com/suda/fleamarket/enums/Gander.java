package com.suda.fleamarket.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

@AllArgsConstructor
public enum Gander {
    MALE(1, "男"),
    FEMALE(0, "女");

    @EnumValue
    private final int sex;
    private final String text;



    @Override
    public String toString() {
        return this.text;
    }
}
