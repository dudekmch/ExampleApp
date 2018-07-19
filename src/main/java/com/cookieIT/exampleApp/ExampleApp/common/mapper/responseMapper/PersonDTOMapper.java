package com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.common.response.PersonRestModel;

import java.util.List;

public interface PersonDTOMapper {

    PersonRestModel mapDTOToRestModel(PersonDTO personDTO);

    List<PersonRestModel> mapListDTOToListRestModel(List<PersonDTO> personDTOList);

}
