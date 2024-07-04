package com.juego.jueguito.dtos;

import com.juego.jueguito.enums.Symbol;

public class Response {

    DataResponse[] data = new DataResponse[9];

    int index;

    public Response() {
        this.index = -1;
    }

    public void addElement(Position p , Symbol s , boolean initial) {
        this.index = this.index + 1;
        if (this.index < 9) {
            data[index] = new DataResponse(p, s, initial);
        }
    }
    
}
