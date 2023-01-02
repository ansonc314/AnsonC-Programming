package com.example.safe;

import org.junit.Before;
import org.junit.Test;
import java.lang.*;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class test_data {
    class_trial2 f;  // class to be test
    data instruction;
    @Before
    public void setup() throws IOException {
    }

    @Test
    public void mytest() throws IOException {
        data instruction = new data ("test_data_file.txt");
        instruction.create_line_array();
        int list_size = instruction.lines.size();
        assertEquals(list_size,2);
        String str = instruction.read2string();
        assertEquals("line1",str.substring(0,5));
        assertEquals("line2",str.substring(6,11));

    }
}