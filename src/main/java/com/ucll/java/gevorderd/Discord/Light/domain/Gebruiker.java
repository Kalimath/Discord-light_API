package com.ucll.java.gevorderd.Discord.Light.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Gebruiker {

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
