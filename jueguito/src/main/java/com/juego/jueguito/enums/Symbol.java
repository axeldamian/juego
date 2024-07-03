package com.juego.jueguito.enums;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public enum Symbol {

    TRIANGLE_RED( Color.RED , Shape.TRIANGLE ),
    TRIANGLE_BLUE( Color.BLUE , Shape.TRIANGLE ),
    TRIANGLE_YELLOW( Color.YELLOW , Shape.TRIANGLE ),
    TRIANGLE_PINK( Color.PINK , Shape.TRIANGLE ),
    TRIANGLE_VIOLET( Color.VIOLET , Shape.TRIANGLE ),
    CIRCLE_RED( Color.RED , Shape.CIRCLE ),
    CIRCLE_BLUE( Color.BLUE , Shape.CIRCLE ),
    CIRCLE_YELLOW( Color.YELLOW , Shape.CIRCLE ),
    CIRCLE_PINK( Color.PINK , Shape.CIRCLE ),
    CIRCLE_VIOLET( Color.VIOLET , Shape.CIRCLE ),
    SQUARE_RED( Color.RED , Shape.SQUARE ),
    SQUARE_BLUE( Color.BLUE , Shape.SQUARE ),
    SQUARE_YELLOW( Color.YELLOW , Shape.SQUARE ),
    SQUARE_PINK( Color.PINK , Shape.SQUARE ),
    SQUARE_VIOLET( Color.VIOLET , Shape.SQUARE );

    private Color color;

    private Shape shape;


    public Color getColor() {
        return this.color;
    }

    public Shape getShape() {
        return this.shape;
    }

    private Symbol(Color color , Shape shape) {
        this.color = color;
        this.shape = shape;
    }

    public static Set<Symbol> getAllEnums() {
        HashSet<Symbol> set = new HashSet<>();

        set.add(Symbol.TRIANGLE_BLUE);
        set.add(Symbol.TRIANGLE_RED);
        set.add(Symbol.TRIANGLE_YELLOW);
        set.add(Symbol.TRIANGLE_PINK);
        set.add(Symbol.TRIANGLE_VIOLET);

        set.add(Symbol.CIRCLE_RED);
        set.add(Symbol.CIRCLE_BLUE);
        set.add(Symbol.CIRCLE_YELLOW);
        set.add(Symbol.CIRCLE_PINK);
        set.add(Symbol.CIRCLE_VIOLET);

        set.add(Symbol.SQUARE_RED);
        set.add(Symbol.SQUARE_BLUE);
        set.add(Symbol.SQUARE_YELLOW);
        set.add(Symbol.SQUARE_PINK);
        set.add(Symbol.SQUARE_VIOLET);

        return set;
    }

    public static Symbol getRandomSymbol() {
        Iterator<Symbol> symbols = getAllEnums().iterator();
        int cont = 1; // ver si es 0
        Symbol symbol = null;
        int randomNumber = new Random().nextInt( 15 ); // ver si es 14

        while ( symbols.hasNext() && cont < randomNumber ) {
            symbol = symbols.next();
            cont ++;
        }
        return symbol;
    }

    public Symbol getRandomNextSymbol() {
        Symbol symbolRandom = Symbol.getRandomSymbol();
        Iterator<Symbol> nextPossibility = symbolRandom.getNextPossibilities().iterator();
        Symbol nextSymbol = null;
        int cardinalNextPossibilities = symbolRandom.getNextPossibilities().size();
        int randomNumber = new Random().nextInt( cardinalNextPossibilities ); // ver si va -1
        int cont = 1;

        while( nextPossibility.hasNext() && cont < randomNumber ) {
            nextSymbol = nextPossibility.next();
            cont++;
        }
        return nextSymbol;
    }

    public Set<Symbol> getNextPossibilities() {
        HashSet<Symbol> result = new HashSet<>();

        for ( Symbol s : Symbol.getAllEnums() ) {
            if ( this.getColor().getId() == s.getColor().getId() ) {
                result.add(s);
            }

            if ( this.getShape().getId() == s.getShape().getId() ) {
                result.add(s);
            }

        }
        return result;
    }

}
