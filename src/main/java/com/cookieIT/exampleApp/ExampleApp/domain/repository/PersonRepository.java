package com.cookieIT.exampleApp.ExampleApp.domain.repository;

import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface PersonRepository extends JpaRepository<Person, Long> {
}
