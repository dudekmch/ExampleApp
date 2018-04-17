package com.cookieIT.exampleApp.ExampleApp.rest;

import com.cookieIT.exampleApp.ExampleApp.application.service.PersonManager;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.PersonMapper;
import com.cookieIT.exampleApp.ExampleApp.common.response.PersonRestModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1")
@Api("Show message api")
public class PersonApi {

    private final PersonManager personManager;
    private final PersonMapper personMapper;

    @Autowired
    public PersonApi(PersonManager personManager, PersonMapper personMapper) {
        this.personManager = personManager;
        this.personMapper = personMapper;
    }

    @ApiOperation(value = "Show person")
    @RequestMapping(method = RequestMethod.GET, path = "/person/{id}", produces = "application/json")
    public PersonRestModel showPerson(@PathVariable("id") Long id){
        return personMapper.mapDTOToRestModel(personManager.showPerson(id));
    }
}
