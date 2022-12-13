package com.capitole.challenge.pricing;

import com.capitole.challenge.pricing.controller.PriceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PricingApplicationTests {

    @Autowired
    private PriceController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
