package com.example.marco.floor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FloorControllerTest {
    
    @BeforeEach
    void setUp(){
        System.out.println("Called before every test");
    }

    @Test
    public void sanityTest(){
        System.out.println("Sanity test");
        assertEquals(12, 10 + 2);
    }

    @Test
    public void sanityTest2(){
        assertEquals(2,1 + 1);
    }

    @Test
    public void sanityTest3(){
        int a = 3;
        Integer b = 4;
        int c = 3;
        double d = 3.0;
        int e = 2 + 2;
        Integer f = 4;

        String word1 = "hello";
        String word2 = "hello";
        String word3 = "world";
        String word4 = "he" + new String("llo");
        String word5 = new String("hello");

        word1 = new String("hello") + "hi";

        assertEquals(a,c);
        //assertEquals(word1, word2);
        assertTrue(word1 == word2);
        assertTrue(word1.equals(word2));
        assertTrue("hello" == word1);
        assertTrue(d == 3.0);
        assertTrue(b == e);
        assertTrue(b == f);
        assertTrue(word4.equals(word5));
        //assertTrue(word4 == word5);

    }

}
