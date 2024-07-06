package com.juego.jueguito.dtos;

import com.juego.jueguito.enums.Symbol;

public class ResponseItemJson {
    
    private Position position;

    private Symbol symbol;

    public ResponseItemJson( Position pos , Symbol s) {
        super();
        this.position = pos;
        this.symbol = s;
    }

    public Position getPosition() {
        return this.position;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

}
