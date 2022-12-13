package com.capitole.challenge.pricing.controller;

import com.capitole.challenge.pricing.controller.view.PriceView;
import com.capitole.challenge.pricing.domain.Price;
import com.capitole.challenge.pricing.service.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class PriceControllerTest {

    @InjectMocks
    PriceController controller;

    @Mock
    PriceService service;

    @Test
    void testFailThrowControllerException() throws Exception {
        int brandID = 1;
        int productID = 35455;
        LocalDateTime from = LocalDateTime.now();

        when(service.findCurrentProductPrice(any(Integer.class), any(Integer.class), any(LocalDateTime.class),
                any(Boolean.class))).thenThrow(new Exception("error trying to get price"));

        Exception exception = assertThrows(Exception.class, () -> {
            controller.getPrice(productID, brandID, from);
        });

        String expectedMsg = "error trying to get price";
        assertEquals(expectedMsg, exception.getMessage());
    }

    @Test
    void testFailThrowControllerExceptionB() throws Exception {
        int brandID = 1;
        int productID = 35455;
        int priceList = 2;
        LocalDateTime from = LocalDateTime.now();

        Price price = new Price();
        price.setPrice(15);
        price.setBrandID(brandID);
        price.setPriceList(priceList);
        price.setProductID(productID);
        price.setStartDate(LocalDateTime.now());
        price.setEndDate(LocalDateTime.now());

        when(service.findCurrentProductPrice(any(Integer.class), any(Integer.class), any(LocalDateTime.class),
                any(Boolean.class))).thenReturn(java.util.Optional.of(price));

        PriceView response = controller.getPrice(productID, brandID, from);

        assert priceList == response.getPrice_list();
        assert brandID == response.getBrand_id();
        assert productID == response.getProduct_id();
    }
}