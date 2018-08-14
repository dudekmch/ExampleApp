package com.cookieIT.exampleApp.ExampleApp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;

@Transactional(propagation = Propagation.MANDATORY)
public interface PersonRepository extends JpaRepository<Person, Long>, QuerydslPredicateExecutor<Person>, PersonRepositoryCustom {

}
