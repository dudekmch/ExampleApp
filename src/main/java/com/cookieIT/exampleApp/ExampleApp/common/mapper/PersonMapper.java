package com.cookieIT.exampleApp.ExampleApp.common.mapper;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.common.response.PersonRestModel;

public interface PersonMapper {

    PersonRestModel mapDTOToRestModel(PersonDTO personDTO);

}
