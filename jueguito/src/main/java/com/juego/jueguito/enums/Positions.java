package com.juego.jueguito.enums;

public enum Positions {

    A11(1,1),A12(1,2),A13(1,3),A21(2,1),A22(2,2),A23(2,3),A31(3, 1),A32(3,2),A33(3,3);
    
    private int positionX;

    private int positionY;

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public static int distance(Positions e1, Positions e2) {
       return (int) Math.sqrt( Math.pow( e2.getPositionX() - e1.getPositionX(),2 ) + Math.pow( e2.getPositionY() - e1.getPositionY(), 2 ) );
    }

    // validar que x e y son posiciones validas
    private Positions(int posX, int posY) {
        this.positionX = posX;
        this.positionY = posY;
    }

}
