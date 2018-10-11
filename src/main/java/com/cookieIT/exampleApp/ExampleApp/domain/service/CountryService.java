package com.cookieIT.exampleApp.ExampleApp.domain.service;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;

import java.util.List;

public interface CountryService {

    CountryDTO getCountryByName(String name);

    long createCountry(CountryDTO personDTO);

    List<CountryDTO> getAllCountries();
}
