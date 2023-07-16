package com.anson.module1.module1_4;

import com.anson.module1.globalvariables.Colour;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for methods in Class Triangle
 * Test for getArea method and heronsHeight method
 */

public class TriangleTest {

    @Test
    public void getArea() {
        Triangle testTriangle = new Triangle(4,5,3, Colour.BLUE); // create a test triangle of sides 3,4,5
        assertEquals(6,testTriangle.getArea(), 0.1);  // expected area is 6.
    }

    @Test
    public void heronsHeight() {
        Triangle testTriangle = new Triangle(4,5,3, Colour.BLUE);  // create a test triangle of sides 3,4,5
        assertEquals(3,testTriangle.heronsHeight(), 0.1);  // height should be 3 (where the base is side of length 4)
    }



}