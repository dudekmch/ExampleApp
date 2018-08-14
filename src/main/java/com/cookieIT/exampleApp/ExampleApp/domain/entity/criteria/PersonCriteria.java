package com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria;

import org.springframework.data.domain.Sort;
import com.cookieIT.exampleApp.ExampleApp.common.criteria.PageCriteria;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.sort.PersonSortField;

public class PersonCriteria extends PageCriteria {

    private Long id;
    private String firstName;
    private String lastName;
    private PersonSortField.Field sortField;
    private Sort.Direction sortDirection;

    private PersonCriteria(int page, int pageSize) {
        super(page, pageSize);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonSortField.Field getSortField() {
        return sortField;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public static Builder builder(int page, int pageSize) {
        return new Builder(page, pageSize);
    }

    public static class Builder {

        private PersonCriteria personCriteria;

        private Builder(int page, int pageSize) {
            this.personCriteria = new PersonCriteria(page, pageSize);
        }

        public Builder withSortDirection(Sort.Direction sortDirection){
            this.personCriteria.sortDirection = sortDirection;
            return this;
        }

        public Builder withSortField(PersonSortField.Field sortField){
            this.personCriteria.sortField = sortField;
            return this;
        }

        public Builder withId(Long id) {
            this.personCriteria.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.personCriteria.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.personCriteria.lastName = lastName;
            return this;
        }

        public PersonCriteria build() {
            return personCriteria;
        }
    }
}
