package com.juego.jueguito.dtos;

import java.util.HashSet;
import java.util.Set;

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

    public boolean isValid(int width , int height) {
        return ( 1 <= this.getPositionX() && this.getPositionX() <= height &&
                 1 <= this.getPositionY() && this.getPositionY() <= width
               );
    }

    public Set<Position> getNextPossibilities( Position pos , int width , int height) {
        Set<Position> result = new HashSet<>();

        for ( int i = 1; i <= height; i++) {
            for ( int j = 1; j <= width; j++) {
                Position newPos = new Position(i, j);
                if (  Position.distance(pos, newPos) <= 1 ) {
                    result.add(newPos);
                }
            }
        }

        result.removeAll( pos.getDiagonalsValid(width, height) );
        result.remove(pos);
        return result;
    }

    private void addIfIsValid(Set<Position> set , int width , int height) {
        if ( this.isValid( width , height) ) {
            set.add( this );
        }
    }

    public Set<Position> getDiagonalsValid( int width , int height) {
        HashSet<Position> result = new HashSet<>();

        Position topLeft = new Position( this.getPositionX() - 1 , this.getPositionY() - 1 );
        Position topRight = new Position( this.getPositionX() - 1 , this.getPositionY() + 1 );
        Position bottomLeft = new Position( this.getPositionX() + 1 , this.getPositionY() - 1 );        result.add( new Position(positionY, positionX) );
        Position bottomRight = new Position( this.getPositionX() + 1 , this.getPositionY() + 1 );
        
        topLeft.addIfIsValid(result, width, height);
        topRight.addIfIsValid(result, width, height);
        bottomLeft.addIfIsValid(result, width, height);
        bottomRight.addIfIsValid(result, width, height);

        return result;
    }

    @Override
    public String toString() {
        return " [" + this.positionX + "," + this.positionY + "] ";
    }

}
