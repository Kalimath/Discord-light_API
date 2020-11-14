package com.ucll.java.gevorderd.Discord.Light.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ONTVANGER_ID")
    private Gebruiker ontvanger;

    @Column(name = "BERICHT")
    @JsonProperty("bericht")
    private String boodschap;

    @Column(name = "VERZENDDATUM")
    private LocalDateTime verzendDatum;



    public Bericht() {
        //
    }

    public Bericht(Gebruiker afzender, Gebruiker ontvanger, String boodschap, LocalDateTime verzendDatum) {

        this.id = id;
        this.afzender = afzender;
        this.ontvanger = ontvanger;
        this.boodschap = boodschap;
        this.verzendDatum = verzendDatum;
    }

    public long getId() {
        return id;
    }

    public Gebruiker getAfzender() {
        return afzender;
    }

    public Gebruiker getOntvanger() {
        return ontvanger;
    }

    public String getBoodschap() {
        return boodschap;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAfzender(Gebruiker afzender) {
        this.afzender = afzender;
    }

    public void setOntvanger(Gebruiker ontvanger) {
        this.ontvanger = ontvanger;
    }

    public void setBoodschap(String bericht) {
        this.boodschap = bericht;
    }

    public LocalDateTime getVerzendDatum() {
        return verzendDatum;
    }

    public void setVerzendDatum(LocalDateTime verzendDatum) {
        this.verzendDatum = verzendDatum;
    }
}


