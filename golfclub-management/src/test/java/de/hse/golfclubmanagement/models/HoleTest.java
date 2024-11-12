package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;

import org.junit.jupiter.api.Test;

import de.hse.golfclubmanagement.models.Hole;

public class HoleTest {
    @Test
    public void tmp(){
        assertEquals(0, 0);
    }

    //Hole
    // id:long
    // number:int
    // length: int
    // par: int
    // golfcourse: Golfcourse

    //derive test cases based on equivalence partitionoing
    //id
    //1. negative numbers(invalid) -> rep: -1L
    //2. postivie numbers(valid) -> rep: 1L
    //3. positive number larger than long (invalid) -> long.MAX_long +1

    @Test
    void test_id(){
        Hole hole = new Hole();
        hole.setId(1L);
        assertEquals(hole.getId(), 1L);
    }

    @Test
    void test_invalid_id(){
        Hole hole = new Hole();
        hole.setId(-1L);
        assertEquals(hole.getId(), 1L);
    }

    @Test
    void test_invalid_long_max(){
        Hole hole = new Hole();
        hole.setId(Long.MAX_VALUE );
        assertEquals(hole.getId(), Long.MAX_VALUE);
    }

    @Test
    public void testGettersAndSetters(){
        Hole hole = new Hole();
        hole.setPar(1);
        assertEquals(hole.getPar(), 1);
        hole.setPar(2);
        assertEquals(hole.getPar(), 2);
    }
}
