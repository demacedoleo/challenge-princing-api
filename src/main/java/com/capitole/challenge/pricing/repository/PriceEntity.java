package com.capitole.challenge.pricing.repository;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prices")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "brand_id", nullable = false)
    private int brandID;

    @Column(name = "product_id", nullable = false)
    private int productID;

    @Column(name = "price_list", nullable = false)
    private int priceList;

    @Column(name = "priority", nullable = false)
    private int priority;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
}
