package com.juego.jueguito.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SolutionTests {

    @Test
    void testingValuesOfSolutions() {

        Solution s = new Solution();

        assertEquals( -1 , s.getA11() );
        assertEquals( -1 , s.getA12() );
        assertEquals( -1 , s.getA13() );
        assertEquals( -1 , s.getA21() );
        assertEquals( -1 , s.getA22() );
        assertEquals( -1 , s.getA23() );
        assertEquals( -1 , s.getA31() );
        assertEquals( -1 , s.getA32() );
        assertEquals( -1 , s.getA33() );
    }
    
}
