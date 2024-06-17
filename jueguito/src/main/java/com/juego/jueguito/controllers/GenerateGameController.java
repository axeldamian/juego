package com.juego.jueguito.controllers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.juego.jueguito.dtos.Request;
import com.juego.jueguito.dtos.Solution;
import com.juego.jueguito.enums.Positions;
import com.juego.jueguito.services.GameService;

@RestController
public class GenerateGameController {

    Logger log = LogManager.getLogger(GenerateGameController.class);

    @Autowired
    GameService gameService;

    @PostMapping("/generate")
    public ResponseEntity<String> generate(@RequestBody Request json) 
		throws ResponseStatusException {
       
            log.info("call to endpoint /generate");

            ResponseEntity<String> checkRequest = checkRequest(json);
            if ( checkRequest.getStatusCode() == HttpStatus.BAD_REQUEST ) {
              return checkRequest;
            }
            return new ResponseEntity<>( String.valueOf( Positions.distance(Positions.A33, Positions.A11) ) , HttpStatus.OK);
        }

        private ResponseEntity<String> checkRequest(Request request) {
          
          List<String> properties = new ArrayList<String>();
          List<Field> fields = Arrays.asList( request.getClass().getDeclaredFields() );
          for (Field field : fields) {
            properties.add( field.getName() );
          }

          log.info("fields of request");
          log.info(properties);

            if (  !(properties.contains("difficulty") )
                || !(properties.contains("symbolsQuantity")) ) {
             return new ResponseEntity<>("no there are a difficulty or symbols_quantity field", HttpStatus.BAD_REQUEST);
            }

          HashSet<String> words = new HashSet<String>();
          words.add("HARD");
          words.add("MEDIUM");
          words.add("HARD");

          if ( !words.contains( request.getDifficulty() ) ) {
            return new ResponseEntity<>("difficulty is invalid, null or not exist", HttpStatus.BAD_REQUEST);
          }

          if ( request.getSymbolsQuantity() <= 0 ) {
            return new ResponseEntity<>("symbols quantity is smallest or equal than 0, null or not exist", HttpStatus.BAD_REQUEST);
          }

          if ( request.getSymbolsQuantity() > 9 ) {
            return new ResponseEntity<>("symbols quantity is greater than 9", HttpStatus.BAD_REQUEST);
          }

          return new ResponseEntity<>("request valid", HttpStatus.OK);
        }

        private List<Solution> positions(){
          Solution s = new Solution();
          List<Solution> l = new ArrayList<>();
          l.add(s);
          return l;
        }

}
