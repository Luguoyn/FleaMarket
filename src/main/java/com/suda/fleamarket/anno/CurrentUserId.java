package com.suda.fleamarket.anno;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER}) // 修饰范围:方法参数
@Retention(RetentionPolicy.RUNTIME) // 运行时
@Documented
public @interface CurrentUserId {
}
