package com.ucll.java.gevorderd.Discord.Light.dto;

import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;

import java.time.LocalDateTime;

public class BerichtDto {
    private long id;
    private long afzender;
    private String bericht;
    private LocalDateTime verzendDatum;

    public BerichtDto(long id, long afzender, String bericht, LocalDateTime dateTime) {
        setId(id);
        setAfzender(afzender);
        setBericht(bericht);
        setDateTime(dateTime);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAfzender() {
        return afzender;
    }

    public void setAfzender(long afzender) {
        this.afzender = afzender;
    }

    public String getBericht() {
        return bericht;
    }

    public void setBericht(String bericht) {
        this.bericht = bericht;
    }

    public LocalDateTime getDateTime() {
        return verzendDatum;
    }

    public void setDateTime(LocalDateTime dateTime) {
            this.verzendDatum = dateTime;
    }
}
