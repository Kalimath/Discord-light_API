package com.ucll.java.gevorderd.Discord.Light.domain;

import javax.persistence.*;

@Entity
@Table(name = "KANAAL", schema = "DISCORD_LIGHT")
public class Kanaal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TOPIC")
    private String topic;


}
