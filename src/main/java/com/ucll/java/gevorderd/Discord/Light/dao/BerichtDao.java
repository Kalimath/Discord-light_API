package com.ucll.java.gevorderd.Discord.Light.dao;

import com.ucll.java.gevorderd.Discord.Light.domain.Bericht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("berichtenRepo")
public interface BerichtDao extends JpaRepository<Bericht, Long> {
}
