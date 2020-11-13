package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.DtoService;
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

    private DtoService dtoService;

    public GebruikerController(DtoService dtoService) {
        this.dtoService = dtoService;
    }


    @PostMapping("")
    public GebruikerDto voegGebruikerToe(@RequestBody Gebruiker gebruiker) {
        return dtoService.addGebruiker(gebruiker);
    }

    @GetMapping("")
    public List<GebruikerDto> getAlleGebruikers(@RequestParam("username") String username){
        return dtoService.getAllGebruikers(username);
    }






}
