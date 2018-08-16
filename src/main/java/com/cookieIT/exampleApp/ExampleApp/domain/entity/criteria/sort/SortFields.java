package com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.sort;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.google.common.collect.Lists;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

public abstract class SortFields<E> {

    public OrderSpecifier[] mapToFieldNames(E sortField, Sort.Direction direction) {
        List<ComparableExpressionBase> list = getQueryPaths(sortField);
        List<OrderSpecifier> orderSpecifiers = sortQueryPaths(list, direction);
        OrderSpecifier[] array = new OrderSpecifier[orderSpecifiers.size()];
        return orderSpecifiers.toArray(array);
    }

    private List<OrderSpecifier> sortQueryPaths(List<ComparableExpressionBase> list, Sort.Direction direction) {
        List<OrderSpecifier> result = Lists.newArrayList();
        for (ComparableExpressionBase comparableExpressionBase : list) {
            switch (direction) {
                case ASC:
                    result.add(comparableExpressionBase.asc());
                    break;
                case DESC:
                    result.add(comparableExpressionBase.desc());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown sort direction");
            }
        }

        return result;
    }

    abstract List<ComparableExpressionBase> getQueryPaths(E sortField);
}
