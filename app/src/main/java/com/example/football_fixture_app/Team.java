package com.example.football_fixture_app;

public class Team {

    private int id;
    private String name;
    private String logo;

    public Team(){}

    public Team(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public Team(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
