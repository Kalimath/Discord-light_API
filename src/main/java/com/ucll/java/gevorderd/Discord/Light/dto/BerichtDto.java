package com.ucll.java.gevorderd.Discord.Light.dto;

import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;

import java.time.LocalDateTime;

public class BerichtDto {
    private long afzender;
    private String bericht;
    private LocalDateTime dateTime;

    public BerichtDto(long afzender, String bericht, LocalDateTime dateTime) {
        setAfzender(afzender);
        setBericht(bericht);
        setDateTime(dateTime);
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
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
    }
}
