package com.example.database;

import com.example.globalVariables.*;

import java.io.IOException;

public class test_DB_data {

    public static void main(String[] args)  throws IOException {

        CSV_Handler_data csvFileHandle = new CSV_Handler_data("ansonc");

        // step 1a:  Read records from CSV and store them in a LinkedHashMap
        List_Handler_data recordSetHandler = csvFileHandle.CSV2RecordSet();
        recordSetHandler.printRecordSet();



        // step 2b: copy records from hashmap to a csv file
        csvFileHandle.RecordSet2CSV(recordSetHandler);


    }
}
