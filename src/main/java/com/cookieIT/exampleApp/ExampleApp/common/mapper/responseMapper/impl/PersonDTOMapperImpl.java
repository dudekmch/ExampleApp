package com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper.impl;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper.PersonDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.common.response.PersonRestModel;
import org.springframework.stereotype.Component;

@Component
public class PersonDTOMapperImpl implements PersonDTOMapper {

    @Override
    public PersonRestModel mapDTOToRestModel(PersonDTO personDTO) {
        PersonRestModel personRestModel = new PersonRestModel();
        personRestModel.setId(personDTO.getId());
        personRestModel.setFirstName(personDTO.getFirstName());
        personRestModel.setLastName(personDTO.getLastName());

        return personRestModel;
    }
}
