package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.BerichtDao;
import com.ucll.java.gevorderd.Discord.Light.dao.DtoService;
import com.ucll.java.gevorderd.Discord.Light.dao.GebruikerDao;
import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;
import com.ucll.java.gevorderd.Discord.Light.domain.Bericht;
import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import com.ucll.java.gevorderd.Discord.Light.domain.Kanaal;
import com.ucll.java.gevorderd.Discord.Light.dto.GebruikerDto;
import com.ucll.java.gevorderd.Discord.Light.dto.KanaalDto;
import com.ucll.java.gevorderd.Discord.Light.dto.PlaatsBerichtDto;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kanalen")
public class KanaalController {

    private DtoService dtoService;

    public KanaalController(DtoService dtoService) {
        this.dtoService = dtoService;
    }

    @PostMapping("")
    public KanaalDto voegKanaalToe(@RequestBody Kanaal kanaal){
        return dtoService.addKanaal(kanaal);
    }

    @GetMapping("")
    public List<KanaalDto> getAlleKanalen(@RequestParam("topic") String topic){
        return dtoService.getAllKanalen(topic);
    }

    @Transactional
    @PostMapping("/{id}/registraties")
    public GebruikerDto registreerGebruiker(@PathVariable("id") long kanaalId, @RequestBody Gebruiker gebruiker ){
        return dtoService.registerGebruiker(kanaalId,gebruiker);
    }

    @GetMapping("/{id}/registraties")
    public List<Gebruiker> getChannelMembers(@PathVariable("id") long kanaalId){
        return dtoService.getChannelMembers(kanaalId);
    }

    @PostMapping("/{id}/berichten")
    public Bericht plaatsBerichtInKanaal(@PathVariable("id") long kanaalId, @RequestBody PlaatsBerichtDto berichtDto){
        return dtoService.postMessageInChannel(kanaalId, berichtDto);
    }
}
