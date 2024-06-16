package com.juego.jueguito.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    Logger log = LogManager.getLogger(this.getClass().getSimpleName());

    @GetMapping("/ping")
    public String pingGet() {
        log.info("call to endpoint /ping");
        return "pong";
    }

}