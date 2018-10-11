package com.cookieIT.exampleApp.ExampleApp.common.dto;

import com.cookieIT.exampleApp.ExampleApp.common.Currency;

public class CountryDTO {

    private long id;
    private String name;
    private String capital;
    private Currency currency;
    private long population;

    private CountryDTO() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public Currency getCurrency() {
        return currency;
    }

    public long getPopulation() {
        return population;
    }


    public static final class CountryDTOBuilder {
        private long id;
        private String name;
        private String capital;
        private Currency currency;
        private long population;

        private CountryDTOBuilder() {
        }

        public static CountryDTOBuilder aCountryDTO() {
            return new CountryDTOBuilder();
        }

        public CountryDTOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public CountryDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CountryDTOBuilder withCapital(String capital) {
            this.capital = capital;
            return this;
        }

        public CountryDTOBuilder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public CountryDTOBuilder withPopulation(long population) {
            this.population = population;
            return this;
        }

        public CountryDTO build() {
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.name = this.name;
            countryDTO.population = this.population;
            countryDTO.currency = this.currency;
            countryDTO.capital = this.capital;
            return countryDTO;
        }
    }

    @Override public String toString() {
        return "CountryDTO{" + "name='" + name + '\'' + ", capital='" + capital + '\'' + ", currency=" + currency + ", population=" +
                population + '}';
    }
}
