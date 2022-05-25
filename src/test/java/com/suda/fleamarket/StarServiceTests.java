package com.suda.fleamarket;

import com.suda.fleamarket.service.StarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StarServiceTests {
    @Autowired
    StarService starService;

    @Test
    void test1() {
        starService.list().forEach(System.out::println);
    }
}
