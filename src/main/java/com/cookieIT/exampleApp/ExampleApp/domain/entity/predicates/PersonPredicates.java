package com.cookieIT.exampleApp.ExampleApp.domain.entity.predicates;

import com.cookieIT.exampleApp.ExampleApp.domain.entity.QPerson;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.PersonCriteria;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class PersonPredicates {

    private PersonPredicates(){}

    public static Predicate forCriteria(PersonCriteria criteria) {
        BooleanBuilder builder = new BooleanBuilder();

        if (criteria.getId() != null) {
            builder.and(equalsId(criteria.getId()));
        }

        if (criteria.getFirstName() != null) {
            builder.and(equalsFirstName(criteria.getFirstName()));
        }

        if (criteria.getLastName() != null) {
            builder.and(equalsLastName(criteria.getLastName()));
        }

        return builder;
    }

    private static Predicate equalsId(Long id) {
        return QPerson.person.id.eq(id);
    }
    private static Predicate equalsFirstName(String firstName) {
        return QPerson.person.firstName.eq(firstName);
    }
    private static Predicate equalsLastName(String lastName) {
        return QPerson.person.lastName.eq(lastName);
    }
}
