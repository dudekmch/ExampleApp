package com.cookieIT.exampleApp.ExampleApp;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cookieIT.exampleApp.ExampleApp.common.ad.AdPerson;
import com.cookieIT.exampleApp.ExampleApp.infrastructure.ldap.AdPersonRepository;

@SpringBootApplication
public class ExampleAppApplication {

    private static Logger log = LoggerFactory.getLogger(ExampleAppApplication.class);

    @Autowired
    private AdPersonRepository adPersonRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExampleAppApplication.class, args);
    }

    @PostConstruct
    public void setup() {
        log.info("Spring LDAP + Spring Boot Configuration");
        List<AdPerson> persons = adPersonRepository.getPersonNamesFromGroup("developers");
        log.info("developer names: {}", persons.stream().map(AdPerson::toString).collect(Collectors.toList()));
        persons = adPersonRepository.getPersonNamesFromGroup("managers");
        log.info("manager names: {}", persons.stream().map(AdPerson::toString).collect(Collectors.toList()));
    }
}
