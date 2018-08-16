package com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.sort;

import com.cookieIT.exampleApp.ExampleApp.domain.entity.QPerson;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

public class PersonSortField extends SortField<PersonSortField.Field> {

    public enum Field {
        id,
        firstName,
        lastName;
    }

    @Override
    public ComparableExpressionBase<?> getQueryPath(PersonSortField.Field sortField) {
        switch (sortField) {
            case id:
                return QPerson.person.id;
            case firstName:
                return QPerson.person.firstName;
            case lastName:
                return QPerson.person.lastName;

            default:
                throw new IllegalArgumentException("Unknown PrivilegeSortField");
        }
    }

}
