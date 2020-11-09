package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.GebruikerDao;
import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;
import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequestMapping("/gebruikers")
@RestController
public class GebruikerController {

    private final KanaalDao kanaalDao;
    private final GebruikerDao gebruikerDao;

    public GebruikerController(KanaalDao kanaalDao, GebruikerDao gebruikerDao) {
        this.kanaalDao = kanaalDao;
        this.gebruikerDao = gebruikerDao;
    }


    @PostMapping("")
    public Gebruiker voegGebruikerToe(@RequestBody Gebruiker gebruiker) {
        return gebruikerDao.save(gebruiker);
    }

    @GetMapping("")
    public List<Gebruiker> getAlleGebruikers(@RequestParam("username") String username){
        return gebruikerDao.findAllByUsernameContains(username);
    }






}
