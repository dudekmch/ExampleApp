package com.cookieIT.exampleApp.ExampleApp.domain.entity.mapper;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Country;

public interface CountryToDTOMapper {

    CountryDTO map(Country country);
}
