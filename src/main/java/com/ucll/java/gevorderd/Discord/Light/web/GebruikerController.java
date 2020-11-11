package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.GebruikerDao;
import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;
import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import com.ucll.java.gevorderd.Discord.Light.dto.GebruikerDto;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

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
    public GebruikerDto voegGebruikerToe(@RequestBody Gebruiker gebruiker) {
        Gebruiker temp = gebruikerDao.save(gebruiker);
        return new GebruikerDto(temp.getId(), temp.getUsername(), temp.getVoornaam(), temp.getAchternaam());
    }

    @GetMapping("")
    public List<GebruikerDto> getAlleGebruikers(@RequestParam("username") String username){
        List<Gebruiker> gebruikers =  gebruikerDao.findAllByUsernameContains(username);
        List<GebruikerDto> res = new ArrayList<>();
        for (Gebruiker g : gebruikers) {
            res.add(new GebruikerDto(g.getId(), g.getUsername(), g.getVoornaam(),g.getAchternaam()));
        }
        return res;
    }






}
