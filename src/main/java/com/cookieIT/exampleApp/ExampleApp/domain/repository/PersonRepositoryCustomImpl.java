package com.cookieIT.exampleApp.ExampleApp.domain.repository;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.QPerson;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.PersonCriteria;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.sort.PersonSortField;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.predicates.PersonPredicates;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public PersonRepositoryCustomImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Page<Person> showPersons(PersonCriteria personCriteria) {
        Predicate predicate = PersonPredicates.forCriteria(personCriteria);

        return searchPersonByPredicate(personCriteria, predicate);
    }

    private Page<Person> searchPersonByPredicate(PersonCriteria criteria, Predicate predicate) {
        PageRequest pageRequest = new PageRequest(criteria.getPage(), criteria.getPageSize());

        QPerson person = QPerson.person;
        JPAQuery<Person> query = queryFactory.selectFrom(person)
                                             .where(predicate)
                                             .limit(pageRequest.getPageSize())
                                             .offset((long) pageRequest.getPageNumber() * pageRequest.getPageSize());

        if (criteria.getSortDirection() != null && criteria.getSortField() != null) {
            OrderSpecifier<?> orderBy = new PersonSortField().mapToFieldName(criteria.getSortField(), criteria.getSortDirection());
            query.orderBy(orderBy);
        }

        QueryResults<Person> fetchResults = query.fetchResults();

        return new PageImpl<>(fetchResults.getResults(), pageRequest, fetchResults.getTotal());
    }
}
