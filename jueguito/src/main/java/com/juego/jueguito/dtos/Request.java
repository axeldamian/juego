package com.juego.jueguito.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Request {

    private int symbolsQuantity;

    private String difficulty;

    private int height;

    private int width;

    public Request(int symbolsQuantity, String difficulty, int height, int width){
        this.symbolsQuantity = symbolsQuantity;
        this.difficulty = difficulty;
        this.height = height;
        this.width = width;
    }

    public String getDifficulty(){
        return this.difficulty;
    }

    @JsonGetter("symbols_quantity")
    public int getSymbolsQuantity(){
        return this.symbolsQuantity;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

}
