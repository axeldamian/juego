package com.juego.jueguito.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.juego.jueguito.enums.Symbol;

public class ResponseItemJson {
    
    private Position position;

    private Symbol symbol;

    public ResponseItemJson( Position pos , Symbol s) {
        super();
        this.position = pos;
        this.symbol = s;
    }


    @JsonProperty("position")
    public Position getPosition() {
        return this.position;
    }

    @JsonIgnore
    public Symbol getSymbol() {
        return this.symbol;
    }

    @JsonProperty("symbolito")
    public String getSymbolId() {
        return this.symbol.getId();
    }

}
