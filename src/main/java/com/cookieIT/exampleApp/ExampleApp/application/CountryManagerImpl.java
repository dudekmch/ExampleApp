package com.cookieIT.exampleApp.ExampleApp.application;

import com.cookieIT.exampleApp.ExampleApp.application.service.CountryManager;
import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.service.CountryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryManagerImpl implements CountryManager {

    private CountryService countryService;

    public CountryManagerImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }
}
