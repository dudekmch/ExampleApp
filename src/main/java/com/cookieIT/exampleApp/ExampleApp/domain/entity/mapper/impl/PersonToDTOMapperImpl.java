package com.cookieIT.exampleApp.ExampleApp.domain.entity.mapper.impl;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.mapper.PersonToDTOMapper;

public class PersonToDTOMapperImpl implements PersonToDTOMapper {

    @Override
    public PersonDTO map(Person person) {
        return PersonDTO.builder()
                        .withId(person.getId())
                        .withFirstName(person.getFirstName())
                        .withLastName(person.getLastName())
                        .build();
    }
}
