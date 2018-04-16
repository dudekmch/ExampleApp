package com.cookieIT.exampleApp.ExampleApp.rest;

import com.cookieIT.exampleApp.ExampleApp.application.service.TestManager;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Person;
import com.cookieIT.exampleApp.ExampleApp.rest.model.PersonRestModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1")
@Api("Show message api")
public class ShowMessageAPI {

    private final TestManager testManager;

    @Autowired
    public ShowMessageAPI(TestManager testManager) {
        this.testManager = testManager;
    }

    @ApiOperation(value = "Show message")
    @RequestMapping(method = RequestMethod.GET, path = "/showMessage")
    public ResponseEntity<String> showMessage(){
        testManager.showMessageForUser();
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("DONE");
    }

    @ApiOperation(value = "Show person")
    @RequestMapping(method = RequestMethod.GET, path = "/person")
    public PersonRestModel showPerson(){
        PersonRestModel personRestModel = new PersonRestModel();
        Person person = testManager.showPerson();
        personRestModel.setId(person.getId());
        personRestModel.setFirstName(person.getFirstName());
        personRestModel.setLastName(person.getLastName());

        return personRestModel;
    }
}
