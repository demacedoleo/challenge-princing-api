package com.capitole.challenge.pricing.service;

import com.capitole.challenge.pricing.domain.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {
    Optional<Price> findCurrentProductPrice(int brandID, int productID, LocalDateTime date, Boolean enabled) throws Exception;
}
