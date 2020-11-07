package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;
import com.ucll.java.gevorderd.Discord.Light.domain.Kanaal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kanalen")
public class KanaalController {

    private final KanaalDao kanaalDao;

    public KanaalController(KanaalDao kanaalDao) {
        this.kanaalDao = kanaalDao;
    }

    @PostMapping("/")
    public Kanaal voegKanaalToe(@RequestBody Kanaal kanaal){
        return kanaalDao.save(kanaal);
    }
}
