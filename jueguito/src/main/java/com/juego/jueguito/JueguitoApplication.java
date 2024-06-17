package com.juego.jueguito;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JueguitoApplication {

	 private static final Logger log = LogManager.getLogger(JueguitoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JueguitoApplication.class, args);
		log.info("start application");
	}

}
