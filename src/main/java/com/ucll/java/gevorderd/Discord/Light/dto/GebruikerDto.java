package com.ucll.java.gevorderd.Discord.Light.dto;

public class GebruikerDto {
    private long id;
    private String username, voornaam, achternaam;

    public GebruikerDto(long id, String username, String voornaam, String achternaam) {
        this.id = id;
        this.username = username;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
}
