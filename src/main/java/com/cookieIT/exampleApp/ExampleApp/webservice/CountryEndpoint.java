package com.cookieIT.exampleApp.ExampleApp.webservice;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.service.CountryService;
import io.spring.guides.gs_producing_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CountryService countryService;

    @Autowired
    public CountryEndpoint(CountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {

        GetCountryResponse response = new GetCountryResponse();
        CountryDTO countryDTO = countryService.getCountryByName(request.getName());

        Country countryws = new Country();
        countryws.setName(countryDTO.getName());
        countryws.setCapital(countryDTO.getCapital());
        countryws.setCurrency(Currency.EUR);
        countryws.setPopulation(countryDTO.getPopulation());
        response.setCountry(countryws);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCountryRequest")
    @ResponsePayload
    public CreateCountryResponse createCountry(@RequestPayload CreateCountryRequest request) {

        CreateCountryResponse response = new CreateCountryResponse();

        CountryDTO countryDTO = CountryDTO.CountryDTOBuilder.aCountryDTO().withName(request.getName()).withCapital(request.getCapital())
                .withPopulation(request.getPopulation()).withCurrency(com.cookieIT.exampleApp.ExampleApp.common.Currency.EUR).build();

        long countryId = countryService.createCountry(countryDTO);

        response.setId(countryId);

        return response;
    }

}
