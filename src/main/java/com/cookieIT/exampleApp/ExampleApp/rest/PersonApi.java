package com.cookieIT.exampleApp.ExampleApp.rest;

import com.cookieIT.exampleApp.ExampleApp.application.service.PersonManager;
import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.requestMapper.RequestPersonToDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper.PersonDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.common.response.PersonRestModel;
import com.cookieIT.exampleApp.ExampleApp.rest.Request.CreatePersonRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/v1")
@Api("Show message api")
public class PersonApi {

    private final PersonManager personManager;
    private final PersonDTOMapper personDTOMapper;
    private final RequestPersonToDTOMapper requestPersonToDTOMapper;

    @Autowired
    public PersonApi(PersonManager personManager, PersonDTOMapper personDTOMapper,
                     RequestPersonToDTOMapper requestPersonToDTOMapper) {
        this.personManager = personManager;
        this.personDTOMapper = personDTOMapper;
        this.requestPersonToDTOMapper = requestPersonToDTOMapper;
    }

    @ApiOperation(value = "Show person")
    @RequestMapping(method = RequestMethod.GET, path = "/person/{id}", produces = "application/json")
    public PersonRestModel showPerson(@PathVariable("id") Long id){
        return personDTOMapper.mapDTOToRestModel(personManager.showPerson(id));
    }

    @ApiOperation(value = "Create person")
    @RequestMapping(method = RequestMethod.POST, path = "/person/create", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PersonRestModel createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest) {
        PersonDTO responsePersonDTO = personManager.createPerson(requestPersonToDTOMapper.mapCreateRequestToDTO(createPersonRequest));
        return personDTOMapper.mapDTOToRestModel(responsePersonDTO);
    }
}
