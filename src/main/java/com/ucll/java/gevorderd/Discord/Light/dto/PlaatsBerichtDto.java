package com.ucll.java.gevorderd.Discord.Light.dto;

import java.time.LocalDateTime;

public class PlaatsBerichtDto {
    private long afzender;
    private String bericht;
    private LocalDateTime verzendDatum;

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
        if(verzendDatum == null){
            verzendDatum = LocalDateTime.now();
        }else{
            this.verzendDatum = verzendDatum;
        }
    }
}
