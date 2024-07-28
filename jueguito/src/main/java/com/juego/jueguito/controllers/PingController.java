package com.juego.jueguito.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juego.jueguito.dtos.PingResponse;

@RestController
public class PingController {

    Logger log = LogManager.getLogger(this.getClass().getSimpleName());

    @GetMapping("/ping")
    public ResponseEntity<PingResponse> pingGet() {
        log.info("call to endpoint /ping");
        return new ResponseEntity<>( new PingResponse("pong") , HttpStatus.OK);
    }

}