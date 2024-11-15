package com.juego.jueguito.dtos;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

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

    @Test
    void testingAboutDimensions() {
        int[][] matrix = new int[3][3];
        matrix[2][2] = 9;

        BoardSolution boardSolution = new BoardSolution(matrix);
        
        assertEquals( 3 , boardSolution.getBoardHeight() );
        assertEquals( 3 , boardSolution.getBoardHeight() );

        int[][] newMatrix = new int[ matrix.length ][ matrix[0].length ];
        newMatrix[2][2] = matrix[2][2];

        assertEquals( newMatrix[2][2] , boardSolution.getBoard()[2][2] );
    }

    @Test
    void testingAboutCurrentPosition() {
        int[][] matrix = new int[3][3];
        matrix[2][1] = 5;

        BoardSolution boardSolution = new BoardSolution(matrix);

        boardSolution.setCurrentPosition( 2 + 1 , 1 + 1 );
        boardSolution.setNextIncrementalValue();
        Dimension dimensions = new Dimension( 3 , 2 );

        assertEquals( dimensions , boardSolution.getCurrentPosition()) ;
        assertEquals(3 , boardSolution.getCurrentPositionWidth() );
        assertEquals(2 , boardSolution.getCurrentPositionHeight() );
        assertEquals( 6 , boardSolution.value(3 , 2) );
    }

    @Test
    void testingSolution() throws CloneNotSupportedException {
        int[][] matrix = new int[3][3];
        BoardSolution boardSolution = new BoardSolution(matrix);

        if ( boardSolution.getCalculatedSolutions().isEmpty() ) {
            Set<int[][]> solutions = boardSolution.getAllSolutions(); // algoritmo principal.
            boardSolution.setCalculateAllSolutions(solutions);
        }

        BoardSolution newBoardSolution = boardSolution.getRandomSolution();

        assertTrue( newBoardSolution.checkValidSolution() );
    }

    @Test
    void testingMatrixInvalid() {
        int[][] matrix = new int[3][3];
        matrix[2][2] = 20;

        BoardSolution boardSolution = new BoardSolution(matrix);

        boardSolution.setCurrentPosition(1, 1);

        assertTrue( boardSolution.currentValueIsZero() );
        assertEquals( 20 , boardSolution.getMaximunNumber() );
        assertEquals( 9 , boardSolution.getValueMaxAllowed() );
    }

    @Test
    void testingToString() {
        int[][] matrix = new int[3][3];
        BoardSolution bs = new BoardSolution(matrix);

        StringBuilder sb = new StringBuilder("");

        sb.append("\n");
        sb.append(" ");
        sb.append("0");
        sb.append(" ");
        sb.append("0");
        sb.append(" ");
        sb.append("0");
        sb.append("\n");

        sb.append(" ");
        sb.append("0");
        sb.append(" ");
        sb.append("0");
        sb.append(" ");
        sb.append("0");
        sb.append("\n");

        sb.append(" ");
        sb.append("0");
        sb.append(" ");
        sb.append("0");
        sb.append(" ");
        sb.append("0");
        sb.append("\n");

        assertEquals( sb.toString() , bs.toString() );
    }


    @Test
    void testingThatIsNotSolution() {
        int[][] matrix = new int[3][3];
        BoardSolution bs = new BoardSolution(matrix);

        assertFalse( bs.isSolution() );
    }

    @Test
    void testingAllValidPositions() {
        int[][] matrix = new int[3][3];
        BoardSolution bs = new BoardSolution(matrix);

        HashSet<Position> set = new HashSet<>();
        set.add(new Position(1, 1));
        set.add(new Position(1, 2));
        set.add(new Position(1, 3));

        set.add(new Position(2, 1));
        set.add(new Position(2, 2));
        set.add(new Position(2, 3));

        set.add(new Position(3, 1));
        set.add(new Position(3, 2));
        set.add(new Position(3, 3));

        assertEquals( set, bs.getAllValidPositions() );

    }
    
}
