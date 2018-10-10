package com.cookieIT.exampleApp.ExampleApp.domain.entity.predicates;

import java.util.StringTokenizer;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.QPerson;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.PersonCriteria;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class PersonPredicates {

    private PersonPredicates(){}

    private static QPerson qPerson = QPerson.person;

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

        if (criteria.getPersonSearchString() != null) {
            builder.and(createPredicateForTextSearchingPerson(criteria.getPersonSearchString()));
        }

        return builder;
    }

    private static Predicate equalsId(Long id) {
        return QPerson.person.id.eq(id);
    }
    private static Predicate equalsFirstName(String firstName) {
        return QPerson.person.firstName.lower().eq(firstName.toLowerCase());
    }
    private static Predicate equalsLastName(String lastName) {
        return QPerson.person.lastName.lower().eq(lastName.toLowerCase());
    }

    private static Predicate createPredicateForTextSearchingPerson(String personSearchString) {
        BooleanBuilder builder = new BooleanBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(personSearchString);
        while (stringTokenizer.hasMoreTokens()) {
            String currentTokenValue = stringTokenizer.nextToken();
            BooleanBuilder tokenPredicate = new BooleanBuilder();
            tokenPredicate.or(qPerson.firstName.lower()
                                                                  .startsWith(currentTokenValue.toLowerCase()));
            tokenPredicate.or(qPerson.lastName.lower()
                                                                   .startsWith(currentTokenValue.toLowerCase()));

            builder.and(tokenPredicate);
        }

        return builder;
    }
}
