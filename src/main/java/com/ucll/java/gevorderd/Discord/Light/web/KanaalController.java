package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.*;
import com.ucll.java.gevorderd.Discord.Light.domain.Bericht;
import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import com.ucll.java.gevorderd.Discord.Light.domain.Kanaal;
import com.ucll.java.gevorderd.Discord.Light.dto.BerichtDto;
import com.ucll.java.gevorderd.Discord.Light.dto.GebruikerDto;
import com.ucll.java.gevorderd.Discord.Light.dto.KanaalDto;
import com.ucll.java.gevorderd.Discord.Light.dto.PlaatsBerichtDto;
import com.ucll.java.gevorderd.Discord.Light.dto.berichten.FullBerichtDto;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kanalen")
public class KanaalController extends RuntimeException {

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
    @ResponseStatus(value = HttpStatus.CREATED)
    public String registreerGebruiker(@PathVariable("id") long kanaalId, @RequestBody Gebruiker gebruiker ){
        dtoService.registerGebruiker(kanaalId,gebruiker);
        return "Created";
    }

    @GetMapping("/{id}/registraties")
    public List<Gebruiker> getChannelMembers(@PathVariable("id") long kanaalId){
        return dtoService.getChannelMembers(kanaalId);
    }

    @PostMapping("/{id}/berichten")
    public Object plaatsBerichtInKanaal(@PathVariable("id") long kanaalId, @RequestBody PlaatsBerichtDto berichtDto){
        BerichtDto entity = null;
        String error = "";
        boolean errorFree = true;
        try {
           entity = dtoService.postMessageInChannel(kanaalId, berichtDto);
        }catch (NotRegisteredException e){
            errorFree = false;
            error = e.getMessage();
        }
        if(errorFree){
            return entity;
        }else{
            return error;
        }
    }

    @GetMapping("/{id}/berichten")
    public List<FullBerichtDto> getAlleBerichtenOpKanaal(@PathVariable("id") long id, @RequestParam(value = "username", required = false) String username, @RequestParam(value ="bericht", required = false) String bericht){
        return dtoService.getAllMessagesFromChannel(id, username, bericht);
    }
}
