package com.example.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class List_Handler_dataTest {

    /**
     * Test for the method returnAverage in the List_Handler_data Class
     */
    @Test
    void returnAverage() {
        List_Handler_data testList = new List_Handler_data();

        Record_data r1 = new Record_data(new String[]{"1","2","3","4"});
        Record_data r2 = new Record_data(new String[]{"11","22","33","44"});
        testList.addRecord2First(r1);
        testList.addRecord2First(r2);

        assertEquals(6, testList.returnAverage(0)); // expected value = (1+11)/2

    }
}