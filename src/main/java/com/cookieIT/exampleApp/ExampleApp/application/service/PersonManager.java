package com.cookieIT.exampleApp.ExampleApp.application.service;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;

public interface PersonManager {

    PersonDTO showPerson(Long id);

    PersonDTO createPerson(PersonDTO personDTO);
}
