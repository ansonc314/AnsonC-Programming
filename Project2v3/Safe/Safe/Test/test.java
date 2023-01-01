package com.example.safe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class test {
    testtest f;  // class to be test

    @Before
    public void setup(){
        f = new testtest();
    }

    @Test
    public void mytest(){
        //testtest f = new testtest();
        assertEquals(f.value,110);

    }

}
