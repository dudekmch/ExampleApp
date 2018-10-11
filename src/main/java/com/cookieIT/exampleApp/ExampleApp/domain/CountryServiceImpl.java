package com.cookieIT.exampleApp.ExampleApp.domain;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Country;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.builder.CountryEntityBuilder;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.mapper.CountryToDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.domain.repository.CountryRepository;
import com.cookieIT.exampleApp.ExampleApp.domain.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    private CountryToDTOMapper countryToDTOMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryToDTOMapper countryToDTOMapper) {
        this.countryRepository = countryRepository;
        this.countryToDTOMapper = countryToDTOMapper;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        return countryToDTOMapper.map(countryRepository.findCountryByName(name));
    }

    @Override
    public long createCountry(CountryDTO personDTO) {
        Country country = new CountryEntityBuilder(personDTO.getName(), personDTO.getCapital(), personDTO.getCurrency(), personDTO
                .getPopulation()).build();

        countryRepository.save(country);

        return country.getId();
    }

    @Override
    public List<CountryDTO> getAllCountries(){
        List<Country> countries = countryRepository.findAll();
        return countries.stream().map(countryToDTOMapper::map).collect(Collectors.toList());
    }

}
