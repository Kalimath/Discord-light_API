package com.ucll.java.gevorderd.Discord.Light.dao;

import com.ucll.java.gevorderd.Discord.Light.domain.Bericht;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BerichtDao extends JpaRepository<Bericht, Long> {
}
