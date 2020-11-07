package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;
import com.ucll.java.gevorderd.Discord.Light.domain.Kanaal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public List<Kanaal> getAlleKanalen(@RequestParam("topic") String topic){
        return kanaalDao.findAllByTopicContains(topic);
    }
}
