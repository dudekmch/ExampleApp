package com.cookieIT.exampleApp.ExampleApp.domain;


import com.cookieIT.exampleApp.ExampleApp.domain.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public void showMessage() {
        System.out.println("Hello word");
    }
}
