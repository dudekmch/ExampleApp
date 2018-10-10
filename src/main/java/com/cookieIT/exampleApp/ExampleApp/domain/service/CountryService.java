package com.cookieIT.exampleApp.ExampleApp.domain.service;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;

public interface CountryService {

    CountryDTO getCountryById(Long id);

    long createCountry(CountryDTO personDTO);
}
