package com.juego.jueguito.dtos;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BoardSolution {

    static Logger log = LogManager.getLogger(BoardSolution.class);

    private int[][] board;

    private boolean hasChanged;

    public BoardSolution(int[][] board) {
        super();
        this.board = cloneMatrix(board);
        hasChanged = false;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public int getHeight() {
        return this.board.length;
    }

    public int getWidth() {
        return this.board[0].length;
    }

    public int value(int posX, int posY) {
        return this.board[posX][posY];
    }

    public void setValue( int posX, int posY, int value) {
        this.board[posX][posY] = value;
        hasChanged = true;
    }

    public boolean isSquare() {
        return (this.getHeight() == this.getWidth() ) ;
    }

    public boolean isRectangle() {
        return ( this.getHeight() != this.getWidth() );
    }

    public int valueMax() {
        return this.getHeight() * getWidth();
    }
    public boolean hasChanged() {
        return hasChanged;
    }

    private int[][] cloneMatrix( int[][] matrix ) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for ( int i = 0; i < matrix[0].length; i++ ) {
            for ( int j = 0; j < matrix.length; j++ ) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public Set<Position> getAllValidPositions() {
        Set<Position> pos = new HashSet<Position> ();
        for (int i = 1 ; i <= this.getHeight(); i++) {
            for (int j = 1; j <= this.getWidth(); j++) {
                pos.add(new Position(i, j) );
            }
        }
        return pos;
    }

    public Set<Integer> possibleSolutionsValues() {
        HashSet<Integer> set = new HashSet<>();
        int h = 1;
        for ( int i = 0; i < this.getWidth(); i++) {
            for ( int j = 0; j < this.getHeight(); j++) {
                set.add(h);
                h++;
            }
        }
        return set;
    }

    public void fillMatrix(int[][] matrix) {
        for ( int i = 0; i < this.getWidth(); i++ ) {
            for ( int j = 0; j < this.getHeight(); j++ ) {
                board[i][j] = matrix[i][j];
            }
        }
    }


    public boolean isSolution() {

        HashSet<Integer> values = new HashSet<>();
        
        for (int x = 1; x < this.valueMax(); x++) {
            values.add(x);
        }

        for ( int i = 0; i < this.getWidth(); i++ ) {
            for ( int j = 0; j < this.getHeight(); j++ ) {
                values.add( this.value(i,j) );
                if ( this.value(i,j) == 0 ) {
                    return false;
                }
            }
        }
        return values.size() == 9;
    }

    public boolean isComplete() {
        for ( int i = 0; i < this.getWidth(); i++ ) {
            for ( int j = 0; j < this.getHeight(); j++) {
                if ( this.value(i,j) == 0 ) {
                    return false;
                }
            }
        }
        return true;
    }

    public int numberOfCombinations( Set set ) {
        return set.size();
    }

    @Override
    public BoardSolution clone() throws CloneNotSupportedException {
        int[][] newMatrix = new int[this.getWidth()][this.getHeight()];
        BoardSolution newBoard = new BoardSolution(newMatrix);
        newBoard.fillMatrix(this.board);
        return newBoard;
    }

    @Override
    public String toString() {
        String boardString = "\n";
        for ( int i = 0; i < this.getWidth(); i++ ) {
            for ( int j = 0; j < this.getHeight(); j++) {
                boardString = boardString + " " + this.getBoard()[i][j];
            }
            boardString = boardString + "\n";
        }
        return boardString;
    }
    
}
