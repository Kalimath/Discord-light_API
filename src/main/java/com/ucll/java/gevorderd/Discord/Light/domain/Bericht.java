package com.ucll.java.gevorderd.Discord.Light.domain;

import javax.persistence.*;

public class Bericht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "GEBRUIKER.ID")
    private Gebruiker zender;

//    @OneToOne(cascade = {CascadeType.PERSIST}, orphanRemoval = )
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


