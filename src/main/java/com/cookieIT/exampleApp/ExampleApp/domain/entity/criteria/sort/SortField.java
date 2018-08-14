package com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.sort;

import org.springframework.data.domain.Sort.Direction;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

public abstract class SortField<E> {

    public OrderSpecifier mapToFieldName(E sortField, Direction direction) {
        switch (direction) {
            case ASC:
                return getQueryPath(sortField).asc();
            case DESC:
                return getQueryPath(sortField).desc();
            default:
                throw new IllegalArgumentException("Unknown enum");
        }

    }

    abstract ComparableExpressionBase getQueryPath(E sortField);
}
