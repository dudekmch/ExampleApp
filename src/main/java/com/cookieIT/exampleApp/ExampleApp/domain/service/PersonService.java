package com.cookieIT.exampleApp.ExampleApp.domain.service;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PageDTO;
import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.PersonCriteria;

public interface PersonService {

    PageDTO getAllPersons(PersonCriteria personCriteria);

    PersonDTO getPersonById(Long id);

    PersonDTO createPerson(PersonDTO personDTO);
}
