package com.example.database;

import com.example.globalVariables.*;

import java.io.IOException;

public class test_DB {

    public static void main(String[] args)  throws IOException {

        DerbyDatabase_Handler handler = new DerbyDatabase_Handler(SystemInfo.databaseName);

        CSV_Handler_data csvFileHandle = new CSV_Handler_data("ansonc");

        DerbyTable_Handler_data tableHandler = new DerbyTable_Handler_data(handler,"ansonc");

        /*
        We define a class for storing data records in a linkedhashmap.
        */
/*
        // step 1a:  Read records from CSV and store them in a LinkedHashMap
        HashMap_Handler_data recordSetHandler = csvFileHandle.CSV2RecordSet();

        // step 1b: copy records from hashmap to DB
        tableHandler.RecordSet2Derby(recordSetHandler);

        System.out.println("\n");
        tableHandler.printMembers();  // print the records in the database's table

        // step 2a: copy records from DB to hashmap
        HashMap_Handler_data retrieveRS = tableHandler.Derby2RecordSet();

        System.out.println("\n");
        retrieveRS.printRecordSet();  // print the records in the database's table

        // step 2b: copy records from hashmap to a csv file
        csvFileHandle.RecordSet2CSV(retrieveRS);


 */
    }
}
