package com.cookieIT.exampleApp.ExampleApp.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cookieIT.exampleApp.ExampleApp.application.service.PersonManager;
import com.cookieIT.exampleApp.ExampleApp.common.dto.PageDTO;
import com.cookieIT.exampleApp.ExampleApp.common.dto.PersonDTO;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.requestMapper.RequestPersonToDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.responseMapper.PersonDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.PersonCriteria;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.criteria.sort.PersonSortField;
import com.cookieIT.exampleApp.ExampleApp.rest.request.CreatePersonRequest;
import com.cookieIT.exampleApp.ExampleApp.rest.response.PagedResponse;
import com.cookieIT.exampleApp.ExampleApp.rest.response.PersonRestModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/v1")
@Api("Show message api")
public class PersonApi {

    private final PersonManager personManager;
    private final PersonDTOMapper personDTOMapper;
    private final RequestPersonToDTOMapper requestPersonToDTOMapper;

    @Autowired
    public PersonApi(PersonManager personManager, PersonDTOMapper personDTOMapper, RequestPersonToDTOMapper requestPersonToDTOMapper) {
        this.personManager = personManager;
        this.personDTOMapper = personDTOMapper;
        this.requestPersonToDTOMapper = requestPersonToDTOMapper;
    }

    @ApiOperation(value = "Get all persons")
    @GetMapping(path = "/persons", produces = "application/json")
    public PagedResponse<PersonRestModel> getAllPersons(@RequestParam int page, @RequestParam int pageSize,
            @RequestParam(required = false) Sort.Direction sortDirection, @RequestParam(required = false) PersonSortField.Field sortField,
            @RequestParam(required = false) Long id, @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName, @RequestParam(required = false) String personSearchString) {

        PersonCriteria personCriteria = PersonCriteria.builder(page, pageSize)
                                                      .withSortDirection(sortDirection)
                                                      .withSortField(sortField)
                                                      .withId(id)
                                                      .withFirstName(firstName)
                                                      .withLastName(lastName)
                                                      .withPersonSearchString(personSearchString)
                                                      .build();

        PageDTO<PersonDTO> personPage = personManager.getAllPersons(personCriteria);

        return new PagedResponse(personDTOMapper.mapListDTOToListRestModel(personPage.getData()), personPage.getPage(),
                personPage.getPageSize(), personPage.getTotalElements(), personPage.getTotalPages());
    }

    @ApiOperation(value = "Get person")
    @GetMapping(path = "/person/{id}", produces = "application/json")
    public PersonRestModel showPerson(@PathVariable("id") Long id) {
        return personDTOMapper.mapDTOToRestModel(personManager.showPerson(id));
    }

    @ApiOperation(value = "Create person")
    @PostMapping(path = "/person/create", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PersonRestModel createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest) {
        PersonDTO responsePersonDTO = personManager.createPerson(requestPersonToDTOMapper.mapCreateRequestToDTO(createPersonRequest));
        return personDTOMapper.mapDTOToRestModel(responsePersonDTO);
    }
}
