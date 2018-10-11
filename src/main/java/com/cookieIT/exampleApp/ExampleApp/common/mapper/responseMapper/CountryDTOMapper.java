package com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import com.cookieIT.exampleApp.ExampleApp.rest.response.CountryRestModel;

import java.util.List;

public interface CountryDTOMapper {

    List<CountryRestModel> mapListDTOsToListRestModel(List<CountryDTO> countryDTOList);

}
