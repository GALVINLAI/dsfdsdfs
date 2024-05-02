package com.jack.logjul;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogJulApplicationTests {

    @Test
    void contextLoads() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }
    }

}
