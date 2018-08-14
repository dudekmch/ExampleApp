package com.cookieIT.exampleApp.ExampleApp.domain.entity.mapper;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;

public interface PersonToDTOMapper {
    PersonDTO map(Person person);
}
