package com.juego.jueguito.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardSolutionTests {

    @Test
    void testingPosition() {

        int[][] matrix = new int[3][3];
        matrix[2][1] = 7;
        BoardSolution solution = new BoardSolution(matrix);
        Position p = new Position(2 + 1, 1 + 1);

        assertEquals(p , solution.searchByValue(7) );
    }

    @Test
    void testingIfIsSquare() {

        int[][] matrix = new int[3][3];

        BoardSolution boardSolution = new BoardSolution(matrix);

        assertTrue( boardSolution.isSquare() );
        assertFalse( boardSolution.isRectangle() );
    }

    @Test
    void testingIfIsRectangle() {

        int[][] matrix = new int[4][3];

        BoardSolution boardSolution = new BoardSolution(matrix);

        assertFalse( boardSolution.isSquare() );
        assertTrue(  boardSolution.isRectangle() );
    }
    
}
