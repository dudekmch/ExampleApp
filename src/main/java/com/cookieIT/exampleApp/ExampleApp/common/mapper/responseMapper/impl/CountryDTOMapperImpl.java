package com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper.impl;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper.CountryDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.rest.response.CountryRestModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryDTOMapperImpl implements CountryDTOMapper {

    @Override
    public List<CountryRestModel> mapListDTOsToListRestModel(List<CountryDTO> countryDTOList){
        return countryDTOList.stream().map(this::mapDTOToRestModel).collect(Collectors.toList());
    }


    private CountryRestModel mapDTOToRestModel(CountryDTO countryDTO) {
        CountryRestModel countryRestModel = new CountryRestModel();
        countryRestModel.setId(countryDTO.getId());
        countryRestModel.setName(countryDTO.getName());
        countryRestModel.setCapital(countryDTO.getCapital());
        countryRestModel.setCurrency(countryDTO.getCurrency());
        countryRestModel.setPopulation(countryDTO.getPopulation());

        return countryRestModel;
    }
}
