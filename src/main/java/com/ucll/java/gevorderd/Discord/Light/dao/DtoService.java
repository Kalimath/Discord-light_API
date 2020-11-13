package com.ucll.java.gevorderd.Discord.Light.dao;

import com.ucll.java.gevorderd.Discord.Light.domain.Bericht;
import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import com.ucll.java.gevorderd.Discord.Light.domain.Kanaal;
import com.ucll.java.gevorderd.Discord.Light.dto.BerichtDto;
import com.ucll.java.gevorderd.Discord.Light.dto.GebruikerDto;
import com.ucll.java.gevorderd.Discord.Light.dto.KanaalDto;
import com.ucll.java.gevorderd.Discord.Light.dto.PlaatsBerichtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DtoService {

    private GebruikerDao gebruikerDao;
    private KanaalDao kanaalDao;
    private BerichtDao berichtDao;

    @Autowired
    private DtoService(GebruikerDao gebruikerDao, KanaalDao kanaalDao, BerichtDao berichtDao) {
        this.gebruikerDao = gebruikerDao;
        this.kanaalDao = kanaalDao;
        this.berichtDao = berichtDao;
    }

    public GebruikerDto addGebruiker(Gebruiker gebruiker) {
        Gebruiker temp = gebruikerDao.save(gebruiker);
        return toGebruikerDto(temp);
    }

    public List<GebruikerDto> getAllGebruikers(String username){
        return toGebruikerDtoList(gebruikerDao.findAllByUsernameContains(username));
    }

    public KanaalDto addKanaal(Kanaal kanaal){
        Kanaal temp = kanaalDao.save(kanaal);
        return toKanaalDto(temp);
    }

    public List<KanaalDto> getAllKanalen(String topic){
        List<Kanaal> kanalen = kanaalDao.findAllByTopicContains(topic);
        List<KanaalDto> res = new ArrayList<>();
        for (Kanaal temp: kanalen) {
            res.add(toKanaalDto(temp));
        }
        return res;
    }

    public GebruikerDto registerGebruiker(long kanaalId, Gebruiker gebruiker ){
        gebruiker = gebruikerDao.getOne(gebruiker.getId());
        gebruiker.abonneerOpKanaal(kanaalDao.getOne(kanaalId));
        Gebruiker temp = gebruikerDao.save(gebruiker);
        return toGebruikerDto(temp);
    }

    public List<Gebruiker> getChannelMembers(long kanaalId){
        return gebruikerDao.findGebruikersByGeabonneerdeKanalenContains(kanaalDao.getOne(kanaalId));
    }

    public Bericht postMessageInChannel( long kanaalId, PlaatsBerichtDto berichtDto){
        Bericht newBericht = toBericht(berichtDto);
        kanaalDao.getOne(kanaalId).plaatsBericht(newBericht);
        return berichtDao.save(newBericht);
    }

    public GebruikerDto toGebruikerDto(Gebruiker gebruiker){
        return new GebruikerDto(gebruiker.getId(), gebruiker.getUsername(), gebruiker.getVoornaam(), gebruiker.getAchternaam());
    }

    public KanaalDto toKanaalDto(Kanaal kanaal) {
        return new KanaalDto(kanaal.getId(), kanaal.getName(), kanaal.getTopic());
    }

    public List<GebruikerDto> toGebruikerDtoList(List<Gebruiker> gebruikers){
        List<GebruikerDto> result = new ArrayList<>();
        for (Gebruiker g: gebruikers) {
            result.add(toGebruikerDto(g));
        }
        return result;
    }

    public Bericht toBericht(PlaatsBerichtDto berichtDto){
        return new Bericht(gebruikerDao.getOne(berichtDto.getAfzender()),
                            berichtDto.getBericht(),
                            berichtDto.getDateTime());
    }
}
