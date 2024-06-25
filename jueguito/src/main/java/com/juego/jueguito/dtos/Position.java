package com.juego.jueguito.dtos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Position {

    static Logger log = LogManager.getLogger(Position.class);

    private int positionX;

    private int positionY;

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    // Distancia euclidea
    /*
    public static int distance(Position e1, Position e2) {
       return (int) Math.sqrt( Math.pow( e2.getPositionX() - e1.getPositionX(),2 ) + Math.pow( e2.getPositionY() - e1.getPositionY(), 2 ) );
    }*/

    // Distancia de Chebyshov
    public static int distance(Position e1, Position e2) {
        return maximum( Math.abs( e2.getPositionX() - e1.getPositionX() ) , Math.abs( e2.getPositionY() - e1.getPositionY() ) );
    }

    private static int maximum (int a, int b) {
        if ( a > b) {
            return a;
        }
        return b; // >=
    }

    public static int max(int[][] matrix) {
        int max = 0 ;
        for ( int i = 0; i < matrix[i].length; i++ ) {
            for ( int j = 0; j < matrix.length; j++ ) {
             if ( matrix[i][j] > max) {
                max = matrix[i][j];
             }
            }
        }
        return max;
    }

    // validar que x e y son posiciones validas
    public Position(int posX, int posY) {
        this.positionX = posX;
        this.positionY = posY;
    }

    @Override
    public String toString() {
        return " [" + this.positionX + "," + this.positionY + "] ";
    }

}
