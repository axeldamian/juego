package com.juego.jueguito.dtos;

import com.juego.jueguito.enums.Symbol;

public class DataResponse {

    private Position position;

    private Symbol symbol;

    private boolean initial;

    public DataResponse( Position pos , Symbol s , boolean isInitial ) {
        this.position = pos;
        this.symbol = s;
        this.initial = isInitial;
    }

    public Position getPosition() {
        return this.position;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public boolean isInitial() {
        return this.initial;
    }
    
}
