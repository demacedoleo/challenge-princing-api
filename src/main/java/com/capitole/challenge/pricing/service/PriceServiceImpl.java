package com.capitole.challenge.pricing.service;

import com.capitole.challenge.pricing.domain.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public class PriceServiceImpl implements PriceService {
    @Override
    public Optional<Price> findCurrentProductPrice(int brandID, int productID, LocalDateTime date, Boolean enabled) {
        return Optional.empty();
    }
}
