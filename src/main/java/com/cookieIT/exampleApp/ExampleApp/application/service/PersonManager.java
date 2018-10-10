package com.cookieIT.exampleApp.ExampleApp.application.service;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PageDTO;
import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.PersonCriteria;

public interface PersonManager {

    PageDTO<PersonDTO> getAllPersons(PersonCriteria personCriteria);

    PersonDTO showPerson(Long id);

    PersonDTO createPerson(PersonDTO personDTO);
}
