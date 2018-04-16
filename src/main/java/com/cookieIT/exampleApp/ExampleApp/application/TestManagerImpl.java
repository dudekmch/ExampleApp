package com.cookieIT.exampleApp.ExampleApp.application;

import com.cookieIT.exampleApp.ExampleApp.application.service.TestManager;
import com.cookieIT.exampleApp.ExampleApp.domain.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestManagerImpl implements TestManager {

    private final TestService testService;

    @Autowired
    public TestManagerImpl(TestService testService) {
        this.testService = testService;
    }

    @Override
    public void showMessageForUser() {
        testService.showMessage();
    }
}
