package com.cookieIT.exampleApp.ExampleApp.domain.entity.builder;

import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;

public class PersonEntityBuilder implements EntityBuilder<Person> {

    private Person person;

    public PersonEntityBuilder(String firstName, String lastName) {
        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }

    @Override
    public Person build() {
        return person;
    }
}
