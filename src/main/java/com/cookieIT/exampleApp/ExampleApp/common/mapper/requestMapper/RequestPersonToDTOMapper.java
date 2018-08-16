package com.cookieIT.exampleApp.ExampleApp.common.mapper.requestMapper;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.rest.request.CreatePersonRequest;

public interface RequestPersonToDTOMapper {
    PersonDTO mapCreateRequestToDTO(CreatePersonRequest createPersonRequest);
}
