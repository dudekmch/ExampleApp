package com.cookieIT.exampleApp.ExampleApp.domain.service;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    List<PersonDTO> getAllPersons();

    PersonDTO getPersonById(Long id);

    PersonDTO createPerson(PersonDTO personDTO);
}
