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

        Symbol currentSymbol = Symbol.getRandomSymbol();
        boolean isInitial = false;
        Response response = new Response();
    
             //BoardSolution boardSolution = solution.getRandomSolution();
    
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
    
        DataResponse[] data = response.getData();
    
        for ( int x = 0; x < 9; x++ ) {
            DataResponse item = data[x];
            Position pos = item.getPosition();
            int i = pos.getPositionX() - 1;
            int j = pos.getPositionY() - 1;
            this.board[i][j] = item.getSymbol();

            if ( x == 0 ) {
                    this.initialPosition = pos;
            }
            
        }

    }

    public ResponseJson toJson() {
        ResponseJson response = new ResponseJson( this.getBoard() , this.initialPosition);
        return response;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n");
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
