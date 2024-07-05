package com.juego.jueguito.dtos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.juego.jueguito.enums.Symbol;

public class GameBoard {

    static Logger log = LogManager.getLogger(GameBoard.class);

    private Symbol[][] board;

    private int width;

    private int height;

    private Position initialPosition;

    private int[][] solution;

    public Symbol[][] getBoard() {
        return this.board;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public GameBoard(BoardSolution boardSolution) {
        super();

        this.width = boardSolution.getBoardWidth();
        this.height = boardSolution.getBoardHeight();
        this.board = new Symbol[width][height];
        this.solution = boardSolution.getBoard();

    }

    public void buildGameBoard(BoardSolution solution) {

        Symbol currentSymbol = Symbol.getRandomSymbol();
        boolean isInitial = false;
        Response response = new Response();

         BoardSolution boardSolution = solution.getRandomSolution();

        for ( int i = 1; i <= 9; i++ ) {
            Position positionFound = boardSolution.searchByValue(i);

            if ( i == 1 ) {
                isInitial = true;
            } else {
                isInitial = false;
            }

            response.addElement( positionFound , currentSymbol , isInitial );

            currentSymbol = currentSymbol.getRandomNextSymbol();
        }

        for ( int x = 0; x < 9; x++ ) {
            Position pos = response.getData()[x].getPosition();
            if ( pos != null ) {
                int i = pos.getPositionX();
                int j = pos.getPositionY();
                this.board[i][j] = response.getData()[x].getSymbol();
            }
            if ( x == 1 ) {
                this.initialPosition = pos;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        for ( int i = 0; i < this.getWidth(); i++ ) {
            for ( int j = 0; j < this.getHeight(); j++ ) {
                s = s.append(" " + this.getBoard()[i][j] );
            }
            s = s.append("\n");
        }
        s = s.append("initial:" + this.initialPosition);
        s = s.append("\n" + "solution:" + "\n");
        for ( int i = 0; i < this.getWidth(); i++ ) {
            for ( int j = 0; j < this.getHeight(); j++ ) {
                s = s.append(this.solution[i][j] + " ");
            }
            s = s.append("\n");
        }
        return s.toString();
    }
    
}
