package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.KanaalDao;

public class KanaalController {

    private final KanaalDao kanaalDao;

    public KanaalController(KanaalDao kanaalDao) {
        this.kanaalDao = kanaalDao;
    }

}
