package com.ucll.java.gevorderd.Discord.Light.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany
    @JoinColumn(name = "DISCORD_LIGHT.BERICHT_ID")
    private List<Bericht> berichten;

    public Kanaal() {
        setBerichten(new ArrayList<>());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Bericht> getBerichten() {
        return berichten;
    }

    public void setBerichten(List<Bericht> berichten) {
        this.berichten = berichten;
    }

    public void plaatsBericht(Bericht bericht){
        berichten.add(bericht);
    }
}
