package com.cookieIT.exampleApp.ExampleApp.domain.entity.mapper.impl;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Country;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.mapper.CountryToDTOMapper;

public class CountryToDTOMapperImpl implements CountryToDTOMapper {

    @Override
    public CountryDTO map(Country country) {
        return CountryDTO.CountryDTOBuilder.aCountryDTO()
                .withName(country.getName())
                .withCapital(country.getCapital())
                .withCurrency(country.getCurrency())
                .withPopulation(country.getPopulation())
                .build();
    }
}
