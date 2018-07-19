package com.cookieIT.exampleApp.ExampleApp.application;

import com.cookieIT.exampleApp.ExampleApp.application.service.PersonManager;
import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonManagerImpl implements PersonManager {

    private final PersonService personService;

    @Autowired
    public PersonManagerImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersons();
    }

    @Override
    public PersonDTO showPerson(Long id) {
        return personService.getPersonById(id);
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

}
