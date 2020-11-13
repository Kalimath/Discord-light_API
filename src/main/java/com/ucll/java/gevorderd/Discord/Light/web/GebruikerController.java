package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.BerichtDao;
import com.ucll.java.gevorderd.Discord.Light.dao.GebruikerDao;
import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;
import com.ucll.java.gevorderd.Discord.Light.domain.Bericht;
import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import com.ucll.java.gevorderd.Discord.Light.dto.GebruikerDto;
import com.ucll.java.gevorderd.Discord.Light.dto.PlaatsBerichtDto;
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
    private final BerichtDao berichtDao;

    /**
     * @param kanaalDao
     * @param gebruikerDao
     * @param berichtDao
     * */
    public GebruikerController(KanaalDao kanaalDao, GebruikerDao gebruikerDao, BerichtDao berichtDao) {
        this.kanaalDao = kanaalDao;
        this.gebruikerDao = gebruikerDao;
        this.berichtDao = berichtDao;
    }



    /**
     * @param gebruiker
     *
     * @return
     * */
    @PostMapping("")
    public GebruikerDto voegGebruikerToe(@RequestBody Gebruiker gebruiker) {
        Gebruiker temp = gebruikerDao.save(gebruiker);
        return new GebruikerDto(temp.getId(), temp.getUsername(), temp.getVoornaam(), temp.getAchternaam());
    }


    /**
     * @param username
     *
     * @return
     * */
    @GetMapping("")
    public List<GebruikerDto> getAlleGebruikers(@RequestParam("username") String username){
        List<Gebruiker> gebruikers =  gebruikerDao.findAllByUsernameContains(username);
        List<GebruikerDto> res = new ArrayList<>();
        for (Gebruiker g : gebruikers) {
            res.add(new GebruikerDto(g.getId(), g.getUsername(), g.getVoornaam(),g.getAchternaam()));
        }
        return res;
    }



    @PostMapping("{id}/berichten")
    public Bericht stuurBerichtNaarGebruiker(@PathVariable("id") long berichtId,
                                             @RequestBody PlaatsBerichtDto berichtDto) {

//        Bericht nieuwBericht = new Bericht();
//        nieuwBericht.setBericht(berichtDto.getBericht());
//        nieuwBericht.setAfzender(gebruikerDao.getOne(berichtDto.getAfzender()));
//        kanaalDao.getOne(berichtId).plaatsBericht(nieuwBericht);
        Bericht nieuwBericht = new Bericht();
        return nieuwBericht;

    }


}
