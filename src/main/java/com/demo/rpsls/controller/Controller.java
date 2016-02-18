package com.demo.rpsls.controller;

import com.api.rpsls.FightResult;
import com.api.rpsls.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by antti on 18.2.2016.
 */
@RestController
@EnableAutoConfiguration
@ComponentScan("com.engine.*")
public class Controller {

    @Autowired
    private GameEngine engine;

    @RequestMapping("/warriors")
    public String warriors() {
        return ("Warriors: " +engine.getWarriors());
    }

    @RequestMapping("/fight/{warrior1}/{warrior2}")
    public String fight(@PathVariable String warrior1, @PathVariable String warrior2) {
        FightResult result = engine.fight(engine.getWarriorByName(warrior1), engine.getWarriorByName(warrior2));
        return (warrior1 + " will fight against " +warrior2+ " and it " + result.name());
    }

}
