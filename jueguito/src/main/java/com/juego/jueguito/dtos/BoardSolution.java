package com.juego.jueguito.dtos;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BoardSolution {

    static Logger log = LogManager.getLogger(BoardSolution.class);

    private int[][] board;

    public Set<int[][]> solutions = new HashSet<>();

    private Dimension position = new Dimension();

    public BoardSolution(int[][] board) {
        super();
        this.board = cloneMatrix(board);
     }

    public void setBoard( int[][] board) {
        this.board = cloneMatrix(board);
    }

    public Set<int[][]> getCalculatedSolutions() {
        return this.solutions;
    }

    public void setCalculateAllSolutions( Set<int[][]> solutionsSet ) {
        this.solutions.addAll( solutionsSet );
    }

    public int[][] getBoard() {
        return this.board;
    }

    public String getRandomSolution() {

        // generate a random number
        Random rndm = new Random();

        Iterator<int[][]> setIterator = this.solutions.iterator();

        int rndmNumber = rndm.nextInt(this.solutions.size());

        int cont = 0;
        int[][] result = null;

        while(setIterator.hasNext() && cont < rndmNumber){
            result = setIterator.next();
            cont++;
        }

       return new BoardSolution(result).toString();
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

    public Position searchByValue( int value ) {
        for ( int i = 0; i < this.getBoardWidth(); i++ ) {
            for ( int j = 0; j < this.getBoardHeight(); j++ ) {
                if ( this.board[i][j] == value ) {
                    Position p = new Position(i , j);
                    return p;
                }
            }
        }
        return null;
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
        for ( int i = 0 ; i < this.getBoardHeight(); i++ ) {
            for ( int j = 0; j < this.getBoardWidth(); j++ ) {
                pos.add(new Position( i + 1 , j + 1 ) ); // ver si esta bien.
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

        Set<Integer> values = this.possibleSolutionsValues();

        for ( int i = 1; i <= this.getBoardWidth(); i++ ) {
            for ( int j = 1; j <= this.getBoardHeight(); j++ ) {
                values.add( this.value(i , j) );
                if ( this.value(i,j) == 0 ) {
                    return false;
                }
            }
        }
        return ( values.size() == ( this.getBoardWidth() * this.getBoardHeight() ) ) 
        && this.matrixWithNextsValuesValid() && this.nextPossibilitiesIsOk();
    }

    private boolean matrixWithNextsValuesValid() {
        //Dimension currentPosition = this.getCurrentPosition();

        for ( int i = 1; i <= this.getBoardWidth(); i++ ) {
            for ( int j = 1; j <= this.getBoardHeight(); j++ ) {

                //this.setCurrentPosition(i, j);

                boolean predicated = ( this.getBoard()[i - 1][j - 1] == 0 ) || ( this.getBoard()[i - 1][j - 1] > 9 ); //|| nextValue(i,j) == ( this.getBoard()[i][j] + 1  );

                if ( predicated ) {
                    return false;
                }
            }
        }

        //this.setCurrentPosition( (int) currentPosition.getWidth() , (int) currentPosition.getHeight());
        return true;
    }

    private int nextValue( int currentWidth , int currentHeight) {

        int currentValue = this.board[currentWidth][currentHeight];

       if ( 0 <= currentValue && currentValue < 9 ) {
        return currentValue + 1;
       }
        return -1;
    }

    private boolean nextPossibilitiesIsOk() {
        boolean result = true;
        for ( int i = 1; i <= this.getBoardWidth(); i++ ) {
            for ( int j = 1; j <= this.getBoardHeight(); j++ ) {
                Position pos = new Position(i, j);
                result = result && currentPositionIsValid(pos);
                
            }
        }
        return result;
    }

    private boolean currentPositionIsValid(Position pos) {
        Set<Position> nextPossibilities = pos.getNextPossibilities( this.getBoardWidth(), this.getBoardHeight());
        int currentValue = this.board[pos.getPositionX() - 1][pos.getPositionY() - 1];
        for ( Position p : nextPossibilities ) {
            if ( currentValue == 9 || ( currentValue + 1 ) == this.board[p.getPositionX() - 1][p.getPositionY() - 1] ) {
                return true;
            }
        }
        return false;
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

    public Set<int[][]> getAllSolutions() throws CloneNotSupportedException {
        
        HashSet<int[][]> solutionSet = new HashSet<>();

        this.calculateAllSolutions( solutionSet );

        return solutionSet;
    }

    private void calculateAllSolutions(HashSet<int[][]> solutionSet) throws CloneNotSupportedException {

        for ( int i = 1; i <= this.getBoardWidth(); i++ ) {
            for ( int j = 1; j <= this.getBoardHeight(); j++ ) {

                        BoardSolution newBoard = new BoardSolution(this.getBoard());
                        newBoard.setCurrentPosition(i, j);

                        if ( newBoard.currentValueIsZero() ) {
                            newBoard.setNextIncrementalValue();
                    
                            if ( newBoard.checkValidSolution() ) {
                                solutionSet.add( newBoard.getBoard() );
                                return;
                            } else {
                                newBoard.calculateAllSolutions(solutionSet);
                            }
                        }
            }
        }
    }

    private void setNextIncrementalValue() {
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
