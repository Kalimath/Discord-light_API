package com.ucll.java.gevorderd.Discord.Light.dao;

import com.ucll.java.gevorderd.Discord.Light.domain.Bericht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("berichtenRepo")
public interface BerichtDao extends JpaRepository<Bericht, Long> {

    List<Bericht> findBerichtsByOntvanger_Id(long id);

    List<Bericht> findBerichtsByAfzender_UsernameContainsIgnoreCaseAndBoodschapContainsIgnoreCase(String username, String content);
}
