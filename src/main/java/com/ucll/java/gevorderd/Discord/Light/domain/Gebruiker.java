package com.ucll.java.gevorderd.Discord.Light.domain;

import javax.persistence.*;

@Entity
@Table(name = "GEBRUIKER", schema = "DISCORD_LIGHT")
public class Gebruiker {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "VOORNAAM")
    private String voornaam;

    @Column(name = "ACHTERNAAM")
    private String achternaam;


    public Gebruiker() {
        //
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
