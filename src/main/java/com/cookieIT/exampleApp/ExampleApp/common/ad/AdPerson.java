package com.cookieIT.exampleApp.ExampleApp.common.ad;

public class AdPerson {

    private String name;
    private String login;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "AdPerson{" + "name='" + name + '\'' + ", login='" + login + '\'' + '}';
    }
}
