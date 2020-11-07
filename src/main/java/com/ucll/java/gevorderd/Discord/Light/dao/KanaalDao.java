package com.ucll.java.gevorderd.Discord.Light.dao;

import com.ucll.java.gevorderd.Discord.Light.domain.Kanaal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KanaalDao extends JpaRepository<Kanaal, Long> {

    @Query("SELECT k FROM KANAAL k WHERE k.TOPIC LIKE lower(concat('%', ?1,'%'))")
    List<Kanaal> findAllByTopicContains(String topic);
}
