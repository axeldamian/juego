package com.juego.jueguito.dtos;

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

    public int getSymbolsQuantity(){
        return this.symbolsQuantity;
    }

}
