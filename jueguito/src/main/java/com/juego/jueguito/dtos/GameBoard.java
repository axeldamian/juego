package com.juego.jueguito.dtos;

import com.juego.jueguito.enums.Symbol;

public class GameBoard {

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

    public GameBoard(BoardSolution solution) {
        this.super();

        this.width = solution.getBoardWidth();
        this.height = solution.getBoardHeight();
        this.board = new Symbol[solution.getBoardWidth()][solution.getBoardHeight()];
        Symbol currentSymbol = Symbol.getRandomSymbol();

        for ( int i = 0; i < width; i++ ) {
            for ( int j = 0; j < height; j++ ) {
                this.board[i][j] = currentSymbol;
                currentSymbol = currentSymbol.getRandomNextSymbol();
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
        return s.toString();
    }
    
}
