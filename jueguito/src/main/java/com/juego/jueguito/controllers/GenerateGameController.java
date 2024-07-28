package com.juego.jueguito.controllers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.juego.jueguito.dtos.BoardSolution;
import com.juego.jueguito.dtos.GameBoard;
import com.juego.jueguito.dtos.Request;
import com.juego.jueguito.dtos.ResponseJson;
import com.juego.jueguito.enums.Difficulty;
import com.juego.jueguito.services.GameService;

@Service
@RestController
public class GenerateGameController {

    Logger log = LogManager.getLogger(GenerateGameController.class);

    @Autowired
    GameService gameService;

    BoardSolution boardSolution;

    @GetMapping("/generate")
    public ResponseEntity<ResponseJson> generate() throws ResponseStatusException, CloneNotSupportedException {
       
            log.info("call to endpoint /generate");

            /*
            ResponseEntity<String> checkRequest = checkRequest(json);
            if ( checkRequest.getStatusCode() == HttpStatus.BAD_REQUEST ) {
              return checkRequest;
            }*/

            int[][] matrix = new int[3][3];

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            ////////////////////////////////////
   
             if ( boardSolution == null) { // save the matrix and not recalculate.
               boardSolution = new BoardSolution(matrix);
             }
   
             if ( boardSolution.getCalculatedSolutions().isEmpty() ) {
               Set<int[][]> solutions = boardSolution.getAllSolutions(); // algoritmo principal.
               boardSolution.setCalculateAllSolutions(solutions);
             }
             /////////////////////////////////
   
             stopWatch.stop();
             double time = stopWatch.getTotalTime(TimeUnit.MILLISECONDS);
             String msg = String.format( "tiempo en calcular una solución %.2f ms", time );
             log.info(msg);

             //////////////////////////////
              BoardSolution bs = boardSolution.getRandomSolution();
              GameBoard gb = new GameBoard( bs );

              log.info( gb.toString() );
   
             return new ResponseEntity<>( gb.toJson() , HttpStatus.OK);
        }

        @GetMapping("/cardinal-solutions")
        public int getCardinal() throws CloneNotSupportedException {

          int[][] matrix = new int[3][3];

         StopWatch stopWatch = new StopWatch();
         stopWatch.start();

          if ( boardSolution == null) { // save the matrix and not recalculate.
            boardSolution = new BoardSolution(matrix);
          }

          if ( boardSolution.getCalculatedSolutions().isEmpty()) {
            Set<int[][]> solutions = boardSolution.getAllSolutions(); // algoritmo principal.
            boardSolution.setCalculateAllSolutions(solutions);
          }

          stopWatch.stop();
          double time = stopWatch.getTotalTime(TimeUnit.MILLISECONDS);
          String msg = String.format( "tiempo en calcular una solución %.2f ms", time );
          log.info(msg);

          return boardSolution.getCalculatedSolutions().size();
        }

        @GetMapping("/generate-solution")
        public String getASolution() throws CloneNotSupportedException {

          int[][] matrix = new int[3][3];

         StopWatch stopWatch = new StopWatch();
         stopWatch.start();

          if ( boardSolution == null) { // save the matrix and not recalculate.
            boardSolution = new BoardSolution(matrix);
          }

          if ( boardSolution.getCalculatedSolutions().isEmpty()) {
            Set<int[][]> solutions = boardSolution.getAllSolutions(); // algoritmo principal.
            boardSolution.setCalculateAllSolutions(solutions);
          }

          stopWatch.stop();
          double time = stopWatch.getTotalTime(TimeUnit.MILLISECONDS);
          String msg = String.format( "tiempo en calcular una solución %.2f ms", time );
          log.info(msg);

          return boardSolution.getRandomSolution().toString();
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

          if ( !Difficulty.getPossibilities().contains(request.getDifficulty() ) ) {
            return new ResponseEntity<>("difficulty is not easy, medium or hard", HttpStatus.BAD_REQUEST);
          }

          if ( request.getSymbolsQuantity() <= 0 ) {
            return new ResponseEntity<>("symbols quantity is smallest or equal than 0, null or not exist", HttpStatus.BAD_REQUEST);
          }

          if ( request.getSymbolsQuantity() > 9 ) {
            return new ResponseEntity<>("symbols quantity is greater than 9", HttpStatus.BAD_REQUEST);
          }

          return new ResponseEntity<>("request valid", HttpStatus.OK);
        }

}
