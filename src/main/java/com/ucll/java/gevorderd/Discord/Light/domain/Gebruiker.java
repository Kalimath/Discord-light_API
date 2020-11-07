package com.ucll.java.gevorderd.Discord.Light.domain;

import javax.persistence.*;

@Entity
@Table(name = "GEBRUIKER", schema = "DISCORD_LIGHT")
public class Gebruiker {

    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "VOORNAAM")
    private String voornaam;

    @Column(name = "ACHTERNAAM")
    private String achternaam;


    public Gebruiker() {
        //
    }


}
