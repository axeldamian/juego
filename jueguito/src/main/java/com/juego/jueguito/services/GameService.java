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
        BoardSolution game = new BoardSolution(new int[3][3]);
        HashSet<int[][]> solutions = new HashSet<>();
        game.getAllSolutions(solutions);
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
