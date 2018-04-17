package com.cookieIT.exampleApp.ExampleApp.application;

import com.cookieIT.exampleApp.ExampleApp.application.service.PersonManager;
import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonManagerImpl implements PersonManager {

    private final PersonService testService;

    @Autowired
    public PersonManagerImpl(PersonService testService) {
        this.testService = testService;
    }

    @Override
    public PersonDTO showPerson(Long id) {
        return testService.getPersonById(id);
    }


}
