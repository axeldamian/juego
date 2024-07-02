package com.juego.jueguito.enums;

public enum Shape {

    TRIANGLE("triangle"),
    CIRCLE("circle"),
    SQUARE("square");
    
    private String id;

    public String getId() {
        return this.id;
    }

    private Shape(String value) {
        this.id = value;
    }

}
