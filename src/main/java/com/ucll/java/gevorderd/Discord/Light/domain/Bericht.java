package com.ucll.java.gevorderd.Discord.Light.domain;

import javax.persistence.*;

@Entity
@Table(name = "BERICHT", schema = "DISCORD_LIGHT")
public class Bericht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "GEBRUIKER.ID")
    private Gebruiker zender;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ONTVANGER.ID")
    private Gebruiker ontvanger;

    @Column(name = "CONTENT")
    private String content;



    public Bericht() {
        //
    }



    public long getId() {
        return id;
    }





    public void setId(long id) {
        this.id = id;
    }

}


