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

    @Test // this test check create_line_array if it can read all lines in the file
    public void mytest_create_line_array() throws IOException {
        data instruction = new data ("test_data_file.txt");
        instruction.create_line_array();    // read files to lines array
        int list_size = instruction.lines.size();
        assertEquals(list_size,2);    // check size


    }

    @Test // this test check if the read2string function perform correctly or not.
    public void mytest_read2string() throws IOException {
        data instruction = new data ("test_data_file.txt");   // read files to lines array
        instruction.create_line_array();
        String str = instruction.read2string();    // convert the lines array to string
        assertEquals("line1\nline2\n",str.substring(0,12));   // check the strings
    }
}