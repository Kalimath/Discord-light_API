package com.ucll.java.gevorderd.Discord.Light.dto;

import java.time.LocalDateTime;

public class PlaatsBerichtDto {
    private long afzender;
    private String bericht;
    private LocalDateTime dateTime;

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
        if(dateTime == null){
            dateTime = LocalDateTime.now();
        }else{
            this.dateTime = dateTime;
        }
    }
}
