package com.cookieIT.exampleApp.ExampleApp.rest;

import com.cookieIT.exampleApp.ExampleApp.application.service.CountryManager;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper.CountryDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.rest.response.CountryRestModel;
import com.cookieIT.exampleApp.ExampleApp.rest.response.PagedResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1")
@Api("Country")
public class CountryApi {

    private CountryManager countryManager;
    private CountryDTOMapper countryDTOMapper;

    public CountryApi(CountryManager countryManager, CountryDTOMapper countryDTOMapper) {
        this.countryManager = countryManager;
        this.countryDTOMapper = countryDTOMapper;
    }

    @ApiOperation(value = "Get all countries")
    @GetMapping(path = "/countries", produces = "application/json")
    public PagedResponse<CountryRestModel> getAllCountries() {
        List<CountryRestModel> restModelList = countryDTOMapper.mapListDTOsToListRestModel(countryManager.getAllCountries());

        return new PagedResponse<>(restModelList, 0, 0, 0, 0);
    }

}
