package com.juego.jueguito.controllers;

import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.juego.jueguito.dtos.Request;

@RestController
public class GenerateGameController {

    Logger log = LogManager.getLogger(GenerateGameController.class);

    @PostMapping("/generate")
    public ResponseEntity<String> generate(@RequestBody Request json) 
		throws ResponseStatusException {
            log.info("call to endpoint /generate");
            if ( checkRequest(json).getStatusCode() == HttpStatus.BAD_REQUEST ) {
              return checkRequest(json);
            }
            return new ResponseEntity<>("abc", HttpStatus.OK);
        }

        private ResponseEntity<String> checkRequest(Request request) {
          
          HashSet<String> words = new HashSet<String>();
          words.add("HARD");
          words.add("MEDIUM");
          words.add("HARD");

          if ( !words.contains( request.getDifficulty() ) ) {
            return new ResponseEntity<>("difficulty is invalid", HttpStatus.BAD_REQUEST);
          }

          if ( request.getSymbolsQuantity() <= 0 ) {
            return new ResponseEntity<>("symbols quantity is smallest or equal than 0", HttpStatus.BAD_REQUEST);
          }

          if ( request.getSymbolsQuantity() > 9 ) {
            return new ResponseEntity<>("symbols quantity is greater than 9", HttpStatus.BAD_REQUEST);
          }

          return new ResponseEntity<>("request valid", HttpStatus.OK);
        }

    
}
