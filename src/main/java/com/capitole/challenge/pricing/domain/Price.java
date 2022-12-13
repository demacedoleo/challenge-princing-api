package com.capitole.challenge.pricing.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price {
    private int id;
    private int brandID;
    private int productID;
    private int priceList;
    private int priority;
    private double price;
    private boolean enabled;
    private String currency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
