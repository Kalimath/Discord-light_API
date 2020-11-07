package com.ucll.java.gevorderd.Discord.Light.web;

import com.ucll.java.gevorderd.Discord.Light.dao.BerichtDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("berichten")
@RestController
public class BerichtController {

    private final BerichtDao berichtDao;

    public BerichtController(BerichtDao berichtDao) {
        this.berichtDao = berichtDao;
    }
}
