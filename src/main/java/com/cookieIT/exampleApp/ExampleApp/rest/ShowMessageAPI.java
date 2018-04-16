package com.cookieIT.exampleApp.ExampleApp.rest;

import com.cookieIT.exampleApp.ExampleApp.application.service.TestManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void showMessage(){
        testManager.showMessageForUser();
    }
}
