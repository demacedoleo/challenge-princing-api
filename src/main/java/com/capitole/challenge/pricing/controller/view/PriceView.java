package com.capitole.challenge.pricing.controller.view;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceView {
    private int product_id;
    private int brand_id;
    private double price;
    private int price_list;
    private LocalDateTime start_at;
    private LocalDateTime end_at;
}
