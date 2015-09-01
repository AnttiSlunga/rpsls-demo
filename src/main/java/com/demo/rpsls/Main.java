package com.demo.rpsls;

import com.api.rpsls.FightResult;
import com.api.rpsls.GameEngine;
import com.engine.rpsls.GameEngineImpl;
import com.engine.rpsls.warriors.Paper;
import com.engine.rpsls.warriors.Rock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by antti on 25.4.2015.
 */
@Controller
@EnableAutoConfiguration
public class Main {
	
	@Autowired
	private static GameEngine engine;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        GameEngine engine = new GameEngineImpl();
        FightResult result = engine.fight(new Paper(), new Rock());
        return ("Paper : " +result.name());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

}
