package com.juego.jueguito.controllers.enums;

public enum Positions {

    A11("a11"),A12("a12"),A13("a13"),A21("a21"),A22("a22"),A23("a23"),A31("a31"),A32("a32"),A33("a33");
    
    private String position;

    public String getId() {
        return this.position;
    }

    private Positions(String pos) {
        this.position = pos;
    }

}
