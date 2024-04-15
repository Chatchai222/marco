package com.example.marco.floor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FloorEntityTest {

    @Test
    public void givenTwoEntityWithSameAttributeValue_whenIsEqual_thenReturnTrue(){
        FloorEntity ent1 = new FloorEntity(10L, "HM3", 56.2, 37.4, 270.0, 3);
        FloorEntity ent2 = new FloorEntity(10L, "HM3", 56.2, 37.4, 270.0, 3);

        assertTrue(ent1.equals(ent2));
    }
    
}
