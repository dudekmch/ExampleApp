package com.cookieIT.exampleApp.ExampleApp.domain.repository;

import org.springframework.data.domain.Page;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.PersonCriteria;

public interface PersonRepositoryCustom {

    Page<Person> showPersons(PersonCriteria personCriteria);
}
