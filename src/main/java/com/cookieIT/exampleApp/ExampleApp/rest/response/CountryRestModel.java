package com.cookieIT.exampleApp.ExampleApp.rest.response;

import com.cookieIT.exampleApp.ExampleApp.common.Currency;

public class CountryRestModel {

    private long id;
    private String name;
    private String capital;
    private Currency currency;
    private Long population;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
