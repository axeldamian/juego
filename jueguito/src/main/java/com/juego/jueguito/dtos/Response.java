package com.juego.jueguito.dtos;

import com.juego.jueguito.enums.Symbol;

public class Response {

    DataResponse[] data = new DataResponse[9]; // depende del tamaño

    int index;

    public Response() {
        this.index = -1;
    }

    public DataResponse[] getData() {
        return this.data;
    }

    public void addElement(Position p , Symbol symbolId , boolean initial) {
        this.index = this.index + 1;
        if (this.index < 9) {
            DataResponse dr = new DataResponse(p, symbolId, initial);
            data[index] = dr;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{ data: \n");
        int cont = 1;
        for ( int i = 0; i < 9; i++ ) {
            str.append( this.data[i] );
            str.append(" ");
            if ( cont == 3 ) { // dinamico si el tamaño es variable
                str.append("\n");
                cont = 0;
            }
            cont++;
        }
        str.append("}");
        return str.toString();
    }
    
}
