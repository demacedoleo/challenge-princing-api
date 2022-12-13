package com.capitole.challenge.pricing.controller;

import com.capitole.challenge.pricing.controller.mapper.PriceMapper;
import com.capitole.challenge.pricing.controller.view.PriceView;
import com.capitole.challenge.pricing.domain.Price;
import com.capitole.challenge.pricing.service.PriceService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Slf4j
public class PriceController {

    private static final PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    @Autowired
    private PriceService service;

    @GetMapping(value = "/{product_id}/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    PriceView getPrice(@PathVariable("product_id") int productID,
                       @RequestParam("brand_id") int brandID,
                       @RequestParam("start")
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                               LocalDateTime date) throws Exception {
        Optional<Price> price = service.findCurrentProductPrice(brandID, productID, date, true);
        return mapper.view(price.get());
    }
}
