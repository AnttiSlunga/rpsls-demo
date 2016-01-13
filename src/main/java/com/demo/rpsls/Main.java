package com.demo.rpsls;

import com.api.rpsls.FightResult;
import com.api.rpsls.GameEngine;
import com.engine.rpsls.warriors.Paper;
import com.engine.rpsls.warriors.Rock;
import com.engine.rpsls.warriors.Scissors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by antti on 25.4.2015.
 */
@Controller
@EnableAutoConfiguration
@ComponentScan("com.engine.*")
public class Main {
	
	@Autowired
	private GameEngine engine;

    @RequestMapping("/paper")
    @ResponseBody
    String home() {
        FightResult result = engine.fight(new Paper(), new Rock());
        return ("Paper still: " +result.name());
    }

    @RequestMapping("/rock")
    @ResponseBody
    String rock() {
        return ("Rock :" + engine.fight(new Scissors(), new Rock()));
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

}
