package com.suda.fleamarket;

import com.suda.fleamarket.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsServiceTests {
    @Autowired
    GoodsService goodsService;

    @Test
    void testList() {
        goodsService.list().forEach(System.out::println);
    }
}
