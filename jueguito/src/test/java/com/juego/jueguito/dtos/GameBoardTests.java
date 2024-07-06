package com.juego.jueguito.dtos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameBoardTests {

    BoardSolution boardSolution;

    @Test
    void testingPosition() throws CloneNotSupportedException {

        int[][] matrix = new int[3][3];

        if ( boardSolution == null) { // save the matrix and not recalculate.
            boardSolution = new BoardSolution(matrix);
        }

           
        if ( boardSolution.getCalculatedSolutions().isEmpty() ) {
            Set<int[][]> solutions = boardSolution.getAllSolutions(); // algoritmo principal.
            boardSolution.setCalculateAllSolutions(solutions);
        }

        BoardSolution newBoardSolution = boardSolution.getRandomSolution();
        GameBoard gameBoard = new GameBoard( newBoardSolution );

        assertEquals(9 , gameBoard.toJson().getResponse().length );
    }
    
}
