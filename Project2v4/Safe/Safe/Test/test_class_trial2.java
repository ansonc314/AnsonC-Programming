package com.example.safe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class test_class_trial2 {
    class_trial2 f;  // class to be test

    @Before
    public void setup(){
        f = new class_trial2();
    }

    @Test
    public void mytest(){
        //testtest f = new testtest();
        assertEquals(f.value,110);

    }

}
