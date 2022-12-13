package com.capitole.challenge.pricing.repository;

import com.capitole.challenge.pricing.domain.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {
    @Query(
            value = "SELECT p.brandID, p.productID, p.priceList, p.price, p.startDate, p.endDate " +
                    "FROM prices p " +
                    "WHERE  p.brandID = :brandID and p.productID = :productID and p.startDate <= :date and " +
                    "p.enabled = :enabled and p.endDate >= :date",
            nativeQuery = true
    )
    Optional<Price> findCurrentPrice(int brandID, int productID, LocalDateTime date, Boolean enabled);
}
