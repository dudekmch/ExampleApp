package com.cookieIT.exampleApp.ExampleApp.domain;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Country;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.builder.CountryEntityBuilder;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.mapper.CountryToDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.domain.repository.CountryRepository;
import com.cookieIT.exampleApp.ExampleApp.domain.service.CountryService;

public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    private CountryToDTOMapper countryToDTOMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryToDTOMapper countryToDTOMapper) {
        this.countryRepository = countryRepository;
        this.countryToDTOMapper = countryToDTOMapper;
    }

    @Override
    public CountryDTO getCountryById(Long id) {
        return countryToDTOMapper.map(countryRepository.getOne(id));


    }

    @Override
    public long createCountry(CountryDTO personDTO) {
        Country country = new CountryEntityBuilder(personDTO.getName(), personDTO.getCapital(), personDTO.getCurrency(), personDTO
                .getPopulation()).build();
        
        countryRepository.save(country);

        return country.getId();
    }

}
