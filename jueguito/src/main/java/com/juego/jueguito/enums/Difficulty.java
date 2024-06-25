package com.juego.jueguito.enums;

import java.util.HashSet;
import java.util.Set;

public enum Difficulty {

    EASY("easy"), MEDIUM("medium") ,HARD("hard");
    
    private String value;

    public String getValue() {
        return this.value;
    }

    public static Set<String> getPossibilities() {
       Set<String> possibilities = new HashSet<>();
       possibilities.add(Difficulty.EASY.getValue());
       possibilities.add(Difficulty.MEDIUM.getValue());
       possibilities.add(Difficulty.HARD.getValue());
       return possibilities;
    }

    private Difficulty(String value) {
        this.value = value;
    }

}
