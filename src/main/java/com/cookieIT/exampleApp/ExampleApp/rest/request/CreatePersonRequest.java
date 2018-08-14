package com.cookieIT.exampleApp.ExampleApp.rest.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class CreatePersonRequest {

    @ApiModelProperty(name = "first name", required = true)
    @NotNull
    private String firstName;

    @ApiModelProperty(name = "last name", required = true)
    @NotNull
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
