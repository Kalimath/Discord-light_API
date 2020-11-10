package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.BerichtDao;
import com.ucll.java.gevorderd.Discord.Light.dao.GebruikerDao;
import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;
import com.ucll.java.gevorderd.Discord.Light.domain.Bericht;
import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import com.ucll.java.gevorderd.Discord.Light.domain.Kanaal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/kanalen")
public class KanaalController {

    private final GebruikerDao gebruikerDao;
    private final KanaalDao kanaalDao;
    private final BerichtDao berichtDao;

    public KanaalController(GebruikerDao gebruikerDao, KanaalDao kanaalDao, BerichtDao berichtDao) {
        this.gebruikerDao = gebruikerDao;
        this.kanaalDao = kanaalDao;
        this.berichtDao = berichtDao;
    }

    @PostMapping("")
    public Kanaal voegKanaalToe(@RequestBody Kanaal kanaal){
        return kanaalDao.save(kanaal);
    }

    @GetMapping("")
    public List<Kanaal> getAlleKanalen(@RequestParam("topic") String topic){
        return kanaalDao.findAllByTopicContains(topic);
    }

    @Transactional
    @PostMapping("/{id}/registraties")
    public Gebruiker registreerGebruiker(@PathVariable("id") long kanaalId, @RequestBody Gebruiker gebruiker ){
        gebruiker = gebruikerDao.getOne(gebruiker.getId());
        gebruiker.abonneerOpKanaal(kanaalDao.getOne(kanaalId));
        return gebruikerDao.save(gebruiker);
    }

    @GetMapping("/{id}/registraties")
    public List<Gebruiker> getChannelMembers(@PathVariable("id") long kanaalId){
        return gebruikerDao.findGebruikersByGeabonneerdeKanalenContains(kanaalDao.getOne(kanaalId));
    }

    @PostMapping("/{id}/berichten")
    public Bericht plaatsBerichtInKanaal(@PathVariable("id") long kanaalId,
                                         @RequestParam(value = "afzender") long afzender,
                                         @RequestParam(value = "bericht") String bericht){
        Bericht newBericht = new Bericht();
        newBericht.setBericht(bericht);
        newBericht.setAfzender(gebruikerDao.getOne(afzender));
        kanaalDao.getOne(kanaalId).plaatsBericht(newBericht);
        return berichtDao.save(newBericht);
    }
}
