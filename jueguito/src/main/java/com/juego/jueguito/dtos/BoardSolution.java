package com.juego.jueguito.dtos;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BoardSolution {

    static Logger log = LogManager.getLogger(BoardSolution.class);

    private int[][] board;

    private HashSet<int[][]> solutions = new HashSet<>();

    private Dimension position = new Dimension();

    private int[][] pivotMatrix = new int[2][2];

    public BoardSolution(int[][] board) {
        super();
        this.board = cloneMatrix(board);
        this.pivotMatrix = new int[board[0].length][board.length]; // matrix of 0's of size board.
    }

    public Set<int[][]> allSolutions() {
        return this.solutions;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public Dimension getCurrentPosition() {
        return this.position;
    }

    public void setCurrentPosition(int posX , int posY) {
        this.position = new Dimension(posX , posY);
    }

    public int getBoardWidth() {
        return this.board[0].length;
    }

    public int getBoardHeight() {
        return this.board.length;
    }

    public int getCurrentPositionHeight() {
        return (int) this.position.getHeight();
    }

    public int getCurrentPositionWidth() {
        return (int) this.position.getWidth();
    }

    // input is position + 1
    public int value(int posX, int posY) {
        return this.board[posX - 1][posY - 1];
    }

    public boolean currentValueIsZero() {
        int value = this.value(getCurrentPositionWidth(), getCurrentPositionHeight());
        return value == 0;
    }

    public void setValue( int value ) {
        int currentHeight = this.getCurrentPositionHeight();
        int currentWidth = this.getCurrentPositionWidth();
        this.board[currentWidth - 1][currentHeight - 1] = value;
    }

    public boolean isSquare() {
        return (this.getBoardHeight() == this.getBoardWidth() ) ;
    }

    public boolean isRectangle() {
        return ( this.getBoardHeight() != this.getBoardWidth() );
    }

    public int valueMax() {
        return this.getBoardHeight() * getBoardWidth();
    }

    // TODO : ver el parametro matriz.
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
        Set<Position> pos = new HashSet<> ();
        for ( int i = 0 ; i <= this.getBoardHeight(); i++ ) {
            for ( int j = 0; j <= this.getBoardWidth(); j++ ) {
                pos.add(new Position( i + 1, j + 1 ) );
            }
        }
        return pos;
    }

    public Set<Integer> possibleSolutionsValues() {
        HashSet<Integer> set = new HashSet<>();
        int h = 1;
        for ( int i = 0; i < this.getBoardWidth(); i++) {
            for ( int j = 0; j < this.getBoardHeight(); j++) {
                set.add(h);
                h++;
            }
        }
        return set;
    }

    public void fillMatrix(int[][] matrix) {
        for ( int i = 0; i < this.getBoardWidth(); i++ ) {
            for ( int j = 0; j < this.getBoardHeight(); j++ ) {
                // Arrays.copyOf(matrix[i] , matrix[i].lenght);
                this.board[i][j] = matrix[i][j];
            }
        }
    }


    public boolean isSolution() {

        HashSet<Integer> values = new HashSet<>();
        
        for (int x = 1; x < this.valueMax(); x++) {
            values.add(x);
        }

        for ( int i = 0; i < this.getBoardWidth(); i++ ) {
            for ( int j = 0; j < this.getBoardHeight(); j++ ) {
                values.add( this.value(i + 1 , j + 1 ) );
                if ( this.value( i + 1 ,j + 1 ) == 0 ) {
                    return false;
                }
            }
        }
        return values.size() == 9;
    }

    public boolean isComplete() {
        for ( int i = 0; i < this.getBoardWidth(); i++ ) {
            for ( int j = 0; j < this.getBoardHeight(); j++) {
                if ( this.value( i + 1 , j + 1 ) == 0 ) {
                    return false;
                }
            }
        }
        return true;
    }

    public int numberOfCombinations( Set<int[][]> set ) {
        return set.size();
    }

    private boolean checkValidSolution() {
        return this.isComplete() && this.isSolution();
    }

    public void getAllSolutions(BoardSolution currentSolution, HashSet<int[][]> solutionSet) throws CloneNotSupportedException {

        //StopWatch stopWatch = new StopWatch();
        //stopWatch.start();

        for ( int i = 1; i <= this.getBoardWidth(); i++ ) {
            for ( int j = 1; j <= this.getBoardHeight(); j++ ) {

                    //BoardSolution currentSolution = new BoardSolution(this.pivotMatrix);
                    
                   // if ( currentSolution.getCurrentPositionWidth() != i &&
                    //    currentSolution.getCurrentPositionHeight() != j ) {
                        BoardSolution newBoard = new BoardSolution(currentSolution.getBoard());
                        newBoard.setCurrentPosition(i, j);

                        if ( newBoard.currentValueIsZero() ) {
                            //og.info("a");
                            newBoard.setNextIncrementalValue();
                    
                            //log.info("aa");
                            if ( newBoard.checkValidSolution() ) {
                                //log.info("b");
                                solutionSet.add( newBoard.getBoard() );
                            } else {
                                //log.info("c");
                                currentSolution.getAllSolutions( newBoard , solutionSet);
                            }
                        }
            }
        }

        //stopWatch.stop();
        //System.out.println("Elapsed Time in minutes: " + stopWatch.getTotalTime(TimeUnit.MILLISECONDS) );
    }

    private void setNextIncrementalValue() {
        log.info( getMaximunNumber() );
        this.setValue( getMaximunNumber() + 1 );
    }

    private int getMaximunNumber() {
        int max = 0;
        for ( int i = 0; i < this.getBoardWidth(); i++ ) {
            for ( int j = 0; j < this.getBoardHeight(); j++ ) {
                if ( this.board[ i ][ j ]  > max ) {
                    max = this.board[i][j];
                }
            }
        }
        return max;
    }


    @Override
    public BoardSolution clone() throws CloneNotSupportedException {
        int[][] newMatrix = new int[this.pivotMatrix[0].length][this.pivotMatrix.length];
        BoardSolution newBoard = new BoardSolution(newMatrix);
        newBoard.fillMatrix(this.pivotMatrix);
        return newBoard;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder("\n");
        for ( int i = 0; i < this.getBoardWidth(); i++ ) {
            for ( int j = 0; j < this.getBoardHeight(); j++) {
                boardString = boardString.append( " " + this.getBoard()[i][j] );
            }
            boardString = boardString.append( "\n" );
        }
        return boardString.toString();
    }
    
}
