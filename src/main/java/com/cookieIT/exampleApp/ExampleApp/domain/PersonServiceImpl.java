package com.cookieIT.exampleApp.ExampleApp.domain;

import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.builder.PersonEntityBuilder;
import com.cookieIT.exampleApp.ExampleApp.domain.repository.PersonRepository;
import com.cookieIT.exampleApp.ExampleApp.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll()
                               .stream()
                               .map(person -> PersonDTO.builder()
                                                       .withId(person.getId())
                                                       .withFirstName(person.getFirstName())
                                                       .withLastName(person.getLastName())
                                                       .build())
                               .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        Person person = personRepository.getOne(id);
        return PersonDTO.builder()
                        .withId(person.getId())
                        .withFirstName(person.getFirstName())
                        .withLastName(person.getLastName())
                        .build();
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = new PersonEntityBuilder(personDTO.getFirstName(), personDTO.getLastName()).build();
        personRepository.save(person);
        return PersonDTO.builder()
                        .withId(person.getId())
                        .withFirstName(person.getFirstName())
                        .withLastName(person.getLastName())
                        .build();
    }
}
