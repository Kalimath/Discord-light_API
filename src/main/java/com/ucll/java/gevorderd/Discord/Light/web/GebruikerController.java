package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.DtoService;
import com.ucll.java.gevorderd.Discord.Light.dao.GebruikerDao;
import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;
import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import com.ucll.java.gevorderd.Discord.Light.dto.BerichtDto;
import com.ucll.java.gevorderd.Discord.Light.dto.GebruikerDto;
import com.ucll.java.gevorderd.Discord.Light.dto.PlaatsBerichtDto;
import com.ucll.java.gevorderd.Discord.Light.dto.berichten.FullBerichtDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RequestMapping("/gebruikers")
@RestController
public class GebruikerController {

    private DtoService dtoService;

    public GebruikerController(DtoService dtoService) {
        this.dtoService = dtoService;
    }


    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public GebruikerDto voegGebruikerToe(@RequestBody Gebruiker gebruiker) {
        return dtoService.addGebruiker(gebruiker);
    }

    @GetMapping("")
    public List<GebruikerDto> getAlleGebruikers(@RequestParam("username") String username){
        return dtoService.getAllGebruikers(username);
    }


    @PostMapping("/{id}/berichten")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BerichtDto stuurBerichtNaarGebruiker(@PathVariable("id") long ontvangerId, @RequestBody PlaatsBerichtDto berichtDto){
        return dtoService.sendMessageToUser(ontvangerId, berichtDto);
    }

    @GetMapping("/{id}/berichten")
    public List<FullBerichtDto> getAlleBerichtenVanGebruiker(@PathVariable("id") long id){
        return dtoService.getAllMessagesFromUser(id);
    }


}
