package com.cookieIT.exampleApp.ExampleApp.domain;


import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;
import com.cookieIT.exampleApp.ExampleApp.domain.repository.PersonRepository;
import com.cookieIT.exampleApp.ExampleApp.domain.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private final PersonRepository personRepository;

    @Autowired
    public TestServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void showMessage() {
        System.out.println("Hello word");
    }

    @Override
    public Person showPerson() {
        return personRepository.getOne(1L);
    }
}
