package com.cookieIT.exampleApp.ExampleApp.common.dto;

public class PersonDTO {

    private long id;
    private String firstName;
    private String lastName;

    private PersonDTO(){}

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{

        private final PersonDTO dto;

        private Builder(){
            dto = new PersonDTO();
        }

        public Builder withId(long id){
            dto.id = id;
            return this;
        }

        public Builder withFirstName(String firstName){
            dto.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            dto.lastName = lastName;
            return this;
        }

        public PersonDTO build(){
            return dto;
        }

    }
}

