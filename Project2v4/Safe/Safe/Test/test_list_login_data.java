package com.example.safe;

import org.junit.Before;
import org.junit.Test;
import java.lang.*;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.ListView;

import static org.junit.Assert.assertEquals;

public class test_list_login_data {
    data instruction;

    @Before
    public void setup() throws IOException {
    }

    @Test
    public void mytest() throws IOException {
    Main test_main = new Main();
    //test_main.start();

 //       list_login_data list = new list_login_data("test_data_file.txt");
        mixing rand = new mixing("password");
        ArrayList<String> list = new ArrayList<>();
//        ListView<String> a = new ListView<>();

        data instruction = new data ("test_data_file.txt");
        instruction.create_line_array();
        int list_size = instruction.lines.size();
        assertEquals(list_size,2);
        String str = instruction.read2string();
        assertEquals("line1",str.substring(0,5));
        assertEquals("line2",str.substring(6,11));

    }

}
