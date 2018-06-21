package com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.common.response.PersonRestModel;

public interface PersonDTOMapper {

    PersonRestModel mapDTOToRestModel(PersonDTO personDTO);

}
