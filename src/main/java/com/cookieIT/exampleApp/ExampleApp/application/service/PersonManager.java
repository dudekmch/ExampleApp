package com.cookieIT.exampleApp.ExampleApp.application.service;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;

import java.util.List;

public interface PersonManager {

    List<PersonDTO> getAllPersons();

    PersonDTO showPerson(Long id);

    PersonDTO createPerson(PersonDTO personDTO);
}
