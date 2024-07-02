package com.juego.jueguito.dtos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PositionTests {
    
    @Test
    void testingHashCode() {

        Position pos = new Position(2, 1);

        assertEquals(21 , pos.hashCode());
    }

    @Test
    void testingEquals() {
        Position pos1 = new Position(2, 1);
        Position pos2 = new Position(2, 1);

        assertTrue(pos1.equals(pos2));
    }

    @Test
    void isABorder() {
        Position pos = new Position(1, 2);
        assertTrue( Position.getBorders(3, 3).contains(pos) );
    }

    @Test
    void testingBorder() {
        boolean result = true;
        Position pos = new Position(1, 1);
        Set<Position> border = Position.getBorders(3, 3);
        Set<Position> anothersExtremes = pos.getExtremesIfIsValid(border, 3, 3);
        for ( Position p : anothersExtremes ) {
            result = result && ( p.getPositionX() == 1 && p.getPositionY() == 3 ) || ( p.getPositionX() == 3 && p.getPositionY() == 1 );
        }
        assertTrue(result);
    }

}
