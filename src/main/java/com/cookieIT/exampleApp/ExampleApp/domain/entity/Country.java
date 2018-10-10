package com.cookieIT.exampleApp.ExampleApp.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String capital;

    @Column
    private Enum currency;

    @Column
    @Enumerated(EnumType.STRING)
    private long population;

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

    public Enum getCurrency() {
        return currency;
    }

    public void setCurrency(Enum currency) {
        this.currency = currency;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}

