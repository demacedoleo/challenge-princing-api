package com.capitole.challenge.pricing.service;

import com.capitole.challenge.pricing.domain.Price;
import com.capitole.challenge.pricing.repository.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PriceServiceMapper {
    @Mappings({
            @Mapping(source = "brandID", target = "brandID"),
            @Mapping(source = "productID", target = "productID"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "priceList", target = "priceList"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "endDate", target = "endDate")
    })
    Price dto(PriceEntity entity);
}
