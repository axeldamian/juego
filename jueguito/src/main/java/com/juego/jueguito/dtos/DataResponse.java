package com.juego.jueguito.dtos;

import com.juego.jueguito.enums.Symbol;

public class DataResponse {

    private Position position = new Position(0,0);

    private Symbol symbol;

    private boolean initial;

    public DataResponse( Position pos , Symbol s , boolean isInitial ) {
        super();
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append(this.symbol.getId());
            if ( this.initial ) {
                str.append("_x");
            }
        return str.toString();
    }
    
}
