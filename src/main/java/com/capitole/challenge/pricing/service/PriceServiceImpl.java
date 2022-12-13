package com.capitole.challenge.pricing.service;

import com.capitole.challenge.pricing.domain.Price;
import com.capitole.challenge.pricing.repository.PriceEntity;
import com.capitole.challenge.pricing.repository.PriceRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository repository;

    private static final PriceServiceMapper mapper = Mappers.getMapper(PriceServiceMapper.class);

    @Override
    public Optional<Price> findCurrentProductPrice(int brandID, int productID, LocalDateTime date, Boolean enabled) {
        Iterable<PriceEntity> resultSet = repository.findCurrentPrice(brandID, productID, date, enabled);

        if (resultSet.iterator().hasNext()) {
            Optional<PriceEntity> priceEntity = StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(
                            resultSet.iterator(), Spliterator.ORDERED), false).findFirst();
            return Optional.of(mapper.dto(priceEntity.get()));
        }

        return Optional.empty();
    }
}
