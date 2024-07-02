package com.juego.jueguito.enums;

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

}
