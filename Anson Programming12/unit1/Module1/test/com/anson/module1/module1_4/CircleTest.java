package com.anson.module1.module1_4;

import com.anson.module1.globalvariables.Colour;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for methods in Class Circle
 * Test for getArea method
 */

public class CircleTest {

    @Test
    public void getArea() {
        Circle testCircle = new Circle(10,Colour.RED);
        assertEquals(314.159,testCircle.getArea(), 0.1);  // expected area is 314.159
    }
}