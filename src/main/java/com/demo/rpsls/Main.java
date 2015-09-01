package com.demo.rpsls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.api.rpsls.FightResult;
import com.api.rpsls.GameEngine;
import com.engine.rpsls.warriors.*;

/**
 * Created by antti on 25.4.2015.
 */
public class Main {
	
	@Autowired
	private static GameEngine engine;
	
    public static void main(String args[]) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        //GameEngine engine = (GameEngine) applicationContext.getBean("engine");
        FightResult result = engine.fight(new Paper(), new Rock());
        System.out.println("Paper : " +result.name());
    }

}
