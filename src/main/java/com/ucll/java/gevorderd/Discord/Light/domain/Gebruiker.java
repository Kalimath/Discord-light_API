package com.ucll.java.gevorderd.Discord.Light.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            schema = "DISCORD_LIGHT",
            name = "GEBRUIKER_KANAAL",
            joinColumns = @JoinColumn(name = "GEBRUIKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "KANAAL_ID")
    )
    private Set<Kanaal> geabonneerdeKanalen = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "DISCORD_LIGHT.BERICHT_ID")
    private List<Bericht> berichten;

    public Gebruiker() {
        setBerichten(new ArrayList<>());
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

    public void abonneerOpKanaal(Kanaal kanaal) {
        geabonneerdeKanalen.add(kanaal);
    }

    public List<Bericht> getBerichten() {
        return berichten;
    }

    public void setBerichten(List<Bericht> berichten) {
        this.berichten = berichten;
    }

    public void plaatsBericht(Bericht bericht){
        if (berichten == null) berichten = new ArrayList<>();
        berichten.add(bericht);
    }
}
