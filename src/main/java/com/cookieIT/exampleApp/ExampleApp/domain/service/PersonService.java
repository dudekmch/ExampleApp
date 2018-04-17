package com.cookieIT.exampleApp.ExampleApp.domain.service;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;

public interface PersonService {

    PersonDTO getPersonById(Long id);
}
