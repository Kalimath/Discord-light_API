package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.GebruikerDao;
import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("gebruikers")
@RestController
public class GebruikerController {

    private final GebruikerDao gebruikerDao;

    public GebruikerController(GebruikerDao gebruikerDao) {
        this.gebruikerDao = gebruikerDao;
    }


    @PostMapping("/")
    public Gebruiker voegGebruikerToe(@RequestBody Gebruiker gebruiker) {
        return gebruikerDao.save(gebruiker);
    }

    @GetMapping("/")
    public List<Gebruiker> getAlleGebruikers(){
        return gebruikerDao.findAll();
    }




}
