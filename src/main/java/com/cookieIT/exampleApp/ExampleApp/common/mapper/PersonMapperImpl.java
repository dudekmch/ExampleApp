package com.cookieIT.exampleApp.ExampleApp.common.mapper;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.common.response.PersonRestModel;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonRestModel mapDTOToRestModel(PersonDTO personDTO) {
        PersonRestModel personRestModel = new PersonRestModel();
        personRestModel.setId(personDTO.getId());
        personRestModel.setFirstName(personDTO.getFirstName());
        personRestModel.setLastName(personDTO.getLastName());

        return personRestModel;
    }
}
