package com.cookieIT.exampleApp.ExampleApp.domain;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.cookieIT.exampleApp.ExampleApp.common.dto.PageDTO;
import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.builder.PersonEntityBuilder;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.PersonCriteria;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.mapper.PersonToDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.domain.repository.PersonRepository;
import com.cookieIT.exampleApp.ExampleApp.domain.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PageDTO<PersonDTO> getAllPersons(PersonCriteria personCriteria) {
        Page<Person> dataPage = personRepository.showPersons(personCriteria);

        List<PersonDTO> data = dataPage.getContent().stream().map(person -> PersonDTO.builder()
                                                                                     .withId(person.getId())
                                                                                     .withFirstName(person.getFirstName())
                                                                                     .withLastName(person.getLastName())
                                                                                     .build()).collect(Collectors.toList());
        return new PageDTO(data, dataPage.getNumber(), dataPage.getSize(), dataPage.getTotalElements(), dataPage.getTotalPages());
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
