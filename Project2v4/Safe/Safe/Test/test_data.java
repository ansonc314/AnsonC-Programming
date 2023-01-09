package com.example.safe;

import org.junit.Before;
import org.junit.Test;
import java.lang.*;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class test_data {
    data instruction;
    @Before
    public void setup() throws IOException {
    }

    @Test
    public void mytest_create_line_array() throws IOException {
        data instruction = new data ("test_data_file.txt");
        instruction.create_line_array();
        int list_size = instruction.lines.size();
        assertEquals(list_size,2);


    }

    @Test
    public void mytest_read2string() throws IOException {
        data instruction = new data ("test_data_file.txt");
        instruction.create_line_array();
        String str = instruction.read2string();
        assertEquals("line1",str.substring(0,5));
        assertEquals("line2",str.substring(6,11));
        String str2 = "" + str.charAt(5);

        assertEquals("\n",str2);

    }
}