package com.juego.jueguito.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.juego.jueguito.dtos.BoardSolution;
import com.juego.jueguito.dtos.Position;

@Service
public class GameService {

    Logger log = LogManager.getLogger(GameService.class);

    public void generateGameNew() throws CloneNotSupportedException {
        getAllSolutions(new HashSet<>(), new int[3][3]);
    }

    public void getAllSolutions(Set<int[][]> solutions, int[][] prefixMatrix) throws CloneNotSupportedException {

        BoardSolution board = new BoardSolution(prefixMatrix);

        for ( int i = 0; i < board.getWidth(); i++ ) {
            for ( int j = 0; j < board.getHeight(); j++ ) {

                    int max = getMaximunNumber( prefixMatrix );
                   
                    BoardSolution currentSolution = board.clone();
                    if ( currentSolution.value( i , j ) == 0 ) {
                        currentSolution.setValue( i , j , max + 1 );
                    
                        if ( currentSolution.isComplete() ) {
                            solutions.add( currentSolution.getBoard() );
                        } else {
                            getAllSolutions( solutions, currentSolution.getBoard() );
                        }
                    }
            }
        }
    }

    private String printMatrix(int[][] matrix) {
        String s = "\n";
        for ( int i = 0; i < matrix.length ; i++) {
            for ( int j = 0; j < matrix[i].length ; j++ ) {
                s = s + " " + matrix[i][j];
            }
            s = s + "\n";
        }
        return s;
    }

    private void printItems(List<int[][]> list) {
        for(int[][] item : list) {
            log.info(printMatrix(item));
        }
    }

    private int getMaximunNumber(int[][] currentSolution) {
        int max = 0;
        for ( int i = 0; i < currentSolution[0].length; i++ ) {
            for ( int j = 0; j < currentSolution.length; j++ ) {
                if ( currentSolution[i][j] > max ) {
                    max = currentSolution[i][j];
                }
            }
        }
        return max;
    }

    private Set<Position> getNeighbors(Position currentPos, BoardSolution board) {
       
        Set<Position> neighbors = new HashSet<>();

        Set<Position> pos = board.getAllValidPositions();

        for (Position p : pos) {
            if( Position.distance(p, currentPos) == 1 ) {
                neighbors.add(p);
            }
        }

        return neighbors;
    }
    
}
