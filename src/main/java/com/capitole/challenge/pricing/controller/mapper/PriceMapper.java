package com.capitole.challenge.pricing.controller.mapper;

import com.capitole.challenge.pricing.controller.view.PriceView;
import com.capitole.challenge.pricing.domain.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    @Mappings({
            @Mapping(source = "brandID", target = "brand_id"),
            @Mapping(source = "productID", target = "product_id"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "priceList", target = "price_list"),
            @Mapping(source = "startDate", target = "start_at"),
            @Mapping(source = "endDate", target = "end_at")
    })
    PriceView view(Price price);
}
