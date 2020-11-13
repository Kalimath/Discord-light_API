package com.ucll.java.gevorderd.Discord.Light.dao;

import com.ucll.java.gevorderd.Discord.Light.domain.Gebruiker;
import com.ucll.java.gevorderd.Discord.Light.domain.Kanaal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("gebruikersRepo")
public interface GebruikerDao extends JpaRepository<Gebruiker, Long> {

    //@Query("SELECT g FROM GEBRUIKER g WHERE g.USERNAME LIKE lower(concat('%', ?1,'%'))")
    List<Gebruiker> findAllByUsernameContains(String username);

    List<Gebruiker> findGebruikersByGeabonneerdeKanalenContains(Kanaal kanaal);

    Gebruiker findGebruikerByGeabonneerdeKanalenContainsAndIdIs(Kanaal kanaal, long id);
}
