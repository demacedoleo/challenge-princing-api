package com.capitole.challenge.pricing.service;

import com.capitole.challenge.pricing.domain.Price;
import com.capitole.challenge.pricing.repository.PriceEntity;
import com.capitole.challenge.pricing.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class PriceServiceImplTest {
    @InjectMocks
    PriceServiceImpl service;

    @Mock
    PriceRepository repository;

    @Test
    void testFindProductPriceNotEmpty() throws Exception {
        int expectedBrand = 1;
        int expectedProduct = 35455;
        int expectedPriceList = 1;

        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setProductID(expectedProduct);
        priceEntity.setPriceList(expectedPriceList);
        priceEntity.setBrandID(expectedBrand);

        List<PriceEntity> entities = new ArrayList<>();
        entities.add(priceEntity);

        Iterable<PriceEntity> priceEntityIterable = entities;

        when(repository.findCurrentPrice(any(Integer.class), any(Integer.class), any(LocalDateTime.class),
                any(Boolean.class))).thenReturn(priceEntityIterable);
        Optional<Price> current = service.findCurrentProductPrice(1, 35455, LocalDateTime.now(), true);

        assertTrue(current.isPresent());
        assertEquals(expectedBrand, current.get().getBrandID());
        assertEquals(expectedProduct, current.get().getProductID());
        assertEquals(expectedPriceList, current.get().getPriceList());
    }

    @Test
    void testFindProductPriceFirstMatchByPriority() throws Exception {
        PriceEntity minorPriority = new PriceEntity();
        minorPriority.setProductID(35455);
        minorPriority.setPriceList(1);
        minorPriority.setPriority(0);
        minorPriority.setBrandID(1);

        PriceEntity majorPriority = new PriceEntity();
        minorPriority.setProductID(35455);
        minorPriority.setPriceList(2);
        minorPriority.setPriority(1);
        minorPriority.setBrandID(1);

        List<PriceEntity> entities = new ArrayList<>();
        entities.add(minorPriority);
        entities.add(majorPriority);

        entities.sort(Comparator.comparing(PriceEntity::getPriority).reversed());

        Iterable<PriceEntity> priceEntityIterable = entities;

        when(repository.findCurrentPrice(any(Integer.class), any(Integer.class), any(LocalDateTime.class),
                any(Boolean.class))).thenReturn(priceEntityIterable);
        Optional<Price> current = service.findCurrentProductPrice(1, 35455, LocalDateTime.now(), true);

        int expectedPriority = 1;
        int expectedPriceList = 2;

        assertTrue(current.isPresent());
        assertEquals(expectedPriority, current.get().getPriority());
        assertEquals(expectedPriceList, current.get().getPriceList());
    }
}