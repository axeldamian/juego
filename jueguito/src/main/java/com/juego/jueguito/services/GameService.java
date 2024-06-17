package com.juego.jueguito.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.juego.jueguito.enums.Positions;

@Service
public class GameService {

    private Set<String> getNeighbors(Positions current, int sizeOfBoard) {
        Set<String> neighbors = new HashSet<>();
        neighbors.add(null);
        return neighbors;
    }
    
}
