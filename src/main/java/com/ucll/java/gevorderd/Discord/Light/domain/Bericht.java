package com.ucll.java.gevorderd.Discord.Light.domain;

import javax.persistence.*;

@Entity
@Table(name = "BERICHT", schema = "DISCORD_LIGHT")
public class Bericht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "AFZENDER_ID")
    private Gebruiker afzender;

    /*@Column(name = "AFZENDER", insertable = false, updatable = false)
    private Long afzender;*/

//    @ManyToOne(cascade = {CascadeType.PERSIST})
//    @JoinColumn(name = "ONTVANGER.ID")
//    private Gebruiker ontvanger;

    @Column(name = "BERICHT")
    private String bericht;



    public Bericht() {
        //
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
}


