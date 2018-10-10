package com.cookieIT.exampleApp.ExampleApp.domain.repository;

import com.cookieIT.exampleApp.ExampleApp.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findCountryByName(String name);
}
