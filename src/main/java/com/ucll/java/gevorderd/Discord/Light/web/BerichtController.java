package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.BerichtDao;

public class BerichtController {

    private final BerichtDao berichtDao;

    public BerichtController(BerichtDao berichtDao) {
        this.berichtDao = berichtDao;
    }
}
