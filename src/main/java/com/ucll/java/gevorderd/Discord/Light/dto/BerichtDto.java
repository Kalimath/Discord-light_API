package com.ucll.java.gevorderd.Discord.Light.dto;

import java.time.LocalDateTime;

public class BerichtDto {
    private long id;
    private long afzender;
    private String bericht;
    private LocalDateTime verzendDatum;

    public BerichtDto(long id, long afzender, String bericht, LocalDateTime verzendDatum) {
        setId(id);
        setAfzender(afzender);
        setBericht(bericht);
        setVerzendDatum(verzendDatum);
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

    public LocalDateTime getVerzendDatum() {
        return verzendDatum;
    }

    public void setVerzendDatum(LocalDateTime verzendDatum) {
            this.verzendDatum = verzendDatum;
    }
}
