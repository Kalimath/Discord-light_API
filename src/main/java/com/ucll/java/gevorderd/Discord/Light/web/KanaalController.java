package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.GebruikerDao;
import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;
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

    public KanaalController(GebruikerDao gebruikerDao, KanaalDao kanaalDao) {
        this.gebruikerDao = gebruikerDao;
        this.kanaalDao = kanaalDao;
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
    @PostMapping("/{kanaalId}/registraties")
    public Gebruiker registreerGebruiker(@PathVariable("kanaalId") long kanaalId, @RequestBody Gebruiker gebruiker ){
        gebruiker = gebruikerDao.getOne(gebruiker.getId());
        gebruiker.abonneerOpKanaal(kanaalDao.getOne(kanaalId));
        return gebruikerDao.save(gebruiker);
    }
}
