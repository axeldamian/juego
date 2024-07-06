package com.juego.jueguito.enums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SymbolTests {

    @Test
	void testingColor() {

        Symbol s = Symbol.CIRCLE_BLUE;
        assertEquals( "blue" , s.getColor().getId() );

        s = Symbol.SQUARE_BLUE;
        assertEquals( "blue" , s.getColor().getId() );

        s = Symbol.TRIANGLE_BLUE;
        assertEquals( "blue" , s.getColor().getId() );

         /////////// red

        s = Symbol.CIRCLE_RED;
        assertEquals( "red" , s.getColor().getId() );

        s = Symbol.SQUARE_RED;
        assertEquals( "red" , s.getColor().getId() );

        s = Symbol.TRIANGLE_RED;
        assertEquals( "red" , s.getColor().getId() );

        /////////// yellow

        s = Symbol.CIRCLE_YELLOW;
        assertEquals( "yellow" , s.getColor().getId() );

        s = Symbol.SQUARE_YELLOW;
        assertEquals( "yellow" , s.getColor().getId() );

        s = Symbol.TRIANGLE_YELLOW;
        assertEquals( "yellow" , s.getColor().getId() );

         /////////// violet
         
         s = Symbol.CIRCLE_VIOLET;
         assertEquals( "violet" , s.getColor().getId() );
 
         s = Symbol.SQUARE_VIOLET;
         assertEquals( "violet" , s.getColor().getId() );
 
         s = Symbol.TRIANGLE_VIOLET;
         assertEquals( "violet" , s.getColor().getId() );

         /////////// pink
         
         s = Symbol.CIRCLE_PINK;
         assertEquals( "pink" , s.getColor().getId() );
 
         s = Symbol.SQUARE_PINK;
         assertEquals( "pink" , s.getColor().getId() );
 
         s = Symbol.TRIANGLE_PINK;
         assertEquals( "pink" , s.getColor().getId() );

	}
    
    @Test
	void testingShape() {

        Symbol s = Symbol.CIRCLE_BLUE;
        assertEquals( "circle" , s.getShape().getId() );

        s = Symbol.SQUARE_BLUE;
        assertEquals( "square" , s.getShape().getId() );

        s = Symbol.TRIANGLE_BLUE;
        assertEquals( "triangle" , s.getShape().getId() );

         /////////// red

        s = Symbol.CIRCLE_RED;
        assertEquals( "circle" , s.getShape().getId() );

        s = Symbol.SQUARE_RED;
        assertEquals( "square" , s.getShape().getId() );

        s = Symbol.TRIANGLE_RED;
        assertEquals( "triangle" , s.getShape().getId() );

        /////////// yellow

        s = Symbol.CIRCLE_YELLOW;
        assertEquals( "circle" , s.getShape().getId() );

        s = Symbol.SQUARE_YELLOW;
        assertEquals( "square" , s.getShape().getId() );

        s = Symbol.TRIANGLE_YELLOW;
        assertEquals( "triangle" , s.getShape().getId() );

         /////////// violet
         
         s = Symbol.CIRCLE_VIOLET;
         assertEquals( "circle" , s.getShape().getId() );
 
         s = Symbol.SQUARE_VIOLET;
         assertEquals( "square" , s.getShape().getId() );
 
         s = Symbol.TRIANGLE_VIOLET;
         assertEquals( "triangle" , s.getShape().getId() );

         /////////// pink
         
         s = Symbol.CIRCLE_PINK;
         assertEquals( "circle" , s.getShape().getId() );
 
         s = Symbol.SQUARE_PINK;
         assertEquals( "square" , s.getShape().getId() );
 
         s = Symbol.TRIANGLE_PINK;
         assertEquals( "triangle" , s.getShape().getId() );

	}
    
}
