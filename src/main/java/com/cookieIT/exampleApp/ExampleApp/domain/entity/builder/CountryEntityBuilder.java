package com.cookieIT.exampleApp.ExampleApp.domain.entity.builder;

import com.cookieIT.exampleApp.ExampleApp.common.Currency;
import com.cookieIT.exampleApp.ExampleApp.domain.entity.Country;

public class CountryEntityBuilder implements EntityBuilder<Country> {

    private Country country;

    public CountryEntityBuilder(String name, String capital, Currency currency, long population) {
        country = new Country();
        country.setName(name);
        country.setCapital(capital);
        country.setCurrency(currency);
        country.setPopulation(population);
    }


    @Override
    public Country build() {
        return null;
    }
}
