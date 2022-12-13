package com.capitole.challenge.pricing.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {
    @Query(
            nativeQuery = true,
            value = "SELECT " +
                    "p.id, p.brand_id, p.product_id, p.price_list, p.priority, p.price, p.enabled, p.currency, " +
                    "p.start_date, p.end_date " +
                    "FROM prices as p " +
                    "WHERE " +
                    "p.enabled = :enabled and p.brand_id = :brandID and p.product_id = :productID and " +
                    "p.start_date <= :date and p.end_date > :date order by p.priority desc, p.start_date;"
    )
    Iterable<PriceEntity> findCurrentPrice(int brandID, int productID, LocalDateTime date, Boolean enabled);
}
