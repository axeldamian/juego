package com.juego.jueguito.enums;

public enum Color {
    RED("red"),
    BLUE("blue"),
    YELLOW("yellow"),
    PINK("pink"),
    VIOLET("violet");

    private String id;

    public String getId() {
        return this.id;
    }

    private Color(String value) {
        this.id = value;
    }

}
