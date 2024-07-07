package com.juego.jueguito.enums;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DifficultyTests {

    @Test
    void testingPossibilities() {
        Set<String> possibilities = new HashSet<>();
        possibilities.add(Difficulty.EASY.getValue());
        possibilities.add(Difficulty.MEDIUM.getValue());
        possibilities.add(Difficulty.HARD.getValue());

        assertEquals( possibilities , Difficulty.getPossibilities() );
    }
    
}
