package com.juego.jueguito.dtos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.juego.jueguito.enums.Symbol;

public class GameBoard {

    static Logger log = LogManager.getLogger(GameBoard.class);

    private Symbol[][] board;

    private int width;

    private int height;

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

    }

    public Response buildGameBoard(BoardSolution solution) {

        Symbol currentSymbol = Symbol.getRandomSymbol();
        boolean isInitial = false;
        Response response = new Response();

        for ( int i = 1; i <= 9; i++ ) {
            Position positionFound = solution.searchByValue(i);

            if ( i == 1 ) {
                isInitial = true;
            } else {
                isInitial = false;
            }

            response.addElement( positionFound , currentSymbol , isInitial );

            currentSymbol = currentSymbol.getRandomNextSymbol();
        }
        return response;
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
        return s.toString();
    }
    
}
