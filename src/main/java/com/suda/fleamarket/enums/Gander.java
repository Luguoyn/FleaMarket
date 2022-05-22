package com.suda.fleamarket.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gander {
    MALE(1, "男"),
    FEMALE(0, "女");

    private final int ordinal;
    private final String text;

    public static Gander get(int val) {
        for (Gander gander : Gander.values()) {
            if (gander.ordinal == val) {
                return gander;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return this.text;
    }
}
