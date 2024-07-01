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

    public static int max (int[][] matrix) {
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

    private Set<Position> getBorders( int width , int height ) {
        HashSet<Position> result = new HashSet<>();

        if ( isValid( 1 , this.getBoardWidth() ) && isValid( 1 , this.getBoardHeight())) {
            result.add( new Position( 1, 1 ) );// top left.
        }
        result.add( new Position( this.getBoardHeight(), 1) );// bottom left.
        result.add( new Position( 1 , this.getBoardWidth() ) );// top right.
        result.add( new Position( this.getBoardHeight() , this.getBoardWidth()) );// bottom right.

        return result;
    }

    private Set<Position> getborders( int width , int height ) {

        HashSet<Position> borders = new HashSet<>();

        for ( int i = 1; i <= this.getBoardWidth(); i++ ) {
            Position border1 = new Position( 1 , i );
            Position border2 = new Position( this.getBoardWidth() , i );
            borders.add(border1);
            borders.add(border2);
        }

        for ( int j = 1; j <= height; j++ ) {
            Position border3 = new Position( j , 1 );
            Position border4 = new Position( j , height );
            borders.add(border3);
            borders.add(border4);
        }
        return borders;

    }

    private Set<Position> getExtremesIfIsValid( Set borders, int width , int height ) {
        HashSet<Position> result = new HashSet<>();

        if ( borders.contains(this) ) {

            if ( this.getPositionX() == 1 ) {
                result.add( new Position( width , this.getPositionY() ) );
            }

            if ( this.getPositionX() == width ) {
                result.add( new Position( width , this.getPositionY() ) );
            }

            if ( this.getPositionY() == 1 ) {
                result.add( new Position( this.getPositionX() , height) );
            }

            if ( this.getPositionY() == height ) {
                result.add( new Position( this.getPositionX() , 1 ) );
            }

        }
        return result;
    }

    public Set<Position> getNextPossibilities( Position pos , int width , int height) {
        Set<Position> result = new HashSet<>();

            Position newPos = new Position(i, j);
            newPos.addIfIsValid(result, width, height);
    

        //result.removeAll( pos.getDiagonalsValid(width, height) );
        //result.remove(pos);
        return result;
    }

    private void addIfIsValid(Set<Position> set , int width , int height) {
        if ( this.isValid( width , height) ) {
            set.add( this );
        }
    }
    
    private Set<Position> getNeighbors( int width , int height ) {

        HashSet<Position> positions = new HashSet<>();

        for ( int i = 1; i <= width; i++ ) {
            for ( int j = 1; j <= height; j++ ) {
                Position pos = new Position(i, j);
                if ( Position.distance(this, pos) == 1 ) {
                    positions.add(pos);
                }
            }
        }

        positions.removeAll( this.getDiagonals(width, height) );
        return positions;
    }

    public Set<Position> getDiagonals( int width , int height) {
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
