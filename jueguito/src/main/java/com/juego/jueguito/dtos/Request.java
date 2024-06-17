package com.juego.jueguito.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Request {

    private int symbolsQuantity;

    private String difficulty;

    public Request(int symbolsQuantity, String difficulty){
        this.symbolsQuantity = symbolsQuantity;
        this.difficulty = difficulty;
    }

    public String getDifficulty(){
        return this.difficulty;
    }

    @JsonGetter("symbols_quantity")
    public int getSymbolsQuantity(){
        return this.symbolsQuantity;
    }

}
