package com.cookieIT.exampleApp.ExampleApp.common.mapper.requestMapper.impl;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.requestMapper.RequestPersonToDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.rest.request.CreatePersonRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestPersonToDTOMapperImpl implements RequestPersonToDTOMapper {

    @Override
    public PersonDTO mapCreateRequestToDTO(CreatePersonRequest createPersonRequest) {
        return PersonDTO.builder().withFirstName(createPersonRequest.getFirstName())
                .withLastName(createPersonRequest.getLastName()).build();
    }
}
