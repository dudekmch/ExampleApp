package com.cookieIT.exampleApp.ExampleApp.domain;


import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;
import com.cookieIT.exampleApp.ExampleApp.domain.repository.PersonRepository;
import com.cookieIT.exampleApp.ExampleApp.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        Person person = personRepository.getOne(id);
        return PersonDTO.builder().withId(person.getId()).withFirstName(person.getFirstName()).withLastName(person.getLastName()).build();
    }
}
