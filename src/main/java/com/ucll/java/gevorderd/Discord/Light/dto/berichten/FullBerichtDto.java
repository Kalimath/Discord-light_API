package com.ucll.java.gevorderd.Discord.Light.dto.berichten;

import com.ucll.java.gevorderd.Discord.Light.dto.GebruikerDto;

import java.time.LocalDateTime;

public class FullBerichtDto {
    private long id;
    private GebruikerDto afzender;
    private String bericht;
    private LocalDateTime dateTime;

    public FullBerichtDto(GebruikerDto afzender, String bericht, LocalDateTime dateTime) {
        setId(id);
        setBericht(bericht);
        setDateTime(dateTime);
        setAfzender(afzender);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GebruikerDto getAfzender() {
        return afzender;
    }

    public void setAfzender(GebruikerDto afzender) {
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
