package com.ucll.java.gevorderd.Discord.Light.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BERICHT", schema = "DISCORD_LIGHT")
public class Bericht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "AFZENDER_ID")
    private Gebruiker afzender;

    @Column(name = "BERICHT")
    private String bericht;

    @Column(name = "VERZENDDATUM")
    private LocalDateTime verzendDatum;



    public Bericht() {
        //
    }

    public Bericht(Gebruiker afzender, String bericht, LocalDateTime verzendDatum) {

        this.id = id;
        this.afzender = afzender;
        this.bericht = bericht;
        this.verzendDatum = verzendDatum;
    }

    public long getId() {
        return id;
    }

    public Gebruiker getAfzender() {
        return afzender;
    }

    /*public Gebruiker getOntvanger() {
        return ontvanger;
    }*/

    public String getBericht() {
        return bericht;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAfzender(Gebruiker afzender) {
        this.afzender = afzender;
    }

    /*public void setOntvanger(Gebruiker ontvanger) {
        this.ontvanger = ontvanger;
    }*/

    public void setBericht(String bericht) {
        this.bericht = bericht;
    }

    public LocalDateTime getVerzendDatum() {
        return verzendDatum;
    }

    public void setVerzendDatum(LocalDateTime verzendDatum) {
        this.verzendDatum = verzendDatum;
    }
}


