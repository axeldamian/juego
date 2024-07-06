package com.juego.jueguito.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.juego.jueguito.enums.Symbol;

public class ResponseJson {

    private ResponseItemJson[] response = new ResponseItemJson[9];
    
    private Symbol[][] matrixResponse;

    private Position initialPosition = null;

    public ResponseJson(Symbol[][] matrix , Position init) {
        this.matrixResponse = matrix;
        this.initialPosition = init;
        for( int i = 0; i < this.matrixResponse[0].length; i++) {
            for ( int j = 0; j < this.matrixResponse.length; j++ ) {
                Position p = new Position( i + 1 , j + 1 );
                ResponseItemJson item = new ResponseItemJson( p , this.matrixResponse[i][j] );
                response[ 3 * i + j ] = item;
            }
        }
    }

        @JsonProperty("initial_position")
        public Position getInitialPosition() {
            return this.initialPosition;
        }

        public ResponseItemJson[] getResponse() {
            return this.response;
        }

}
