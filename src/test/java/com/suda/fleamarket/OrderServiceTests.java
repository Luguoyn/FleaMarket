package com.suda.fleamarket;

import com.suda.fleamarket.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTests {
    @Autowired
    OrderService orderService;

    @Test
    void test1() {
        orderService.list().forEach(System.out::println);
    }
}
