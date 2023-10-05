package com.example.database;

import com.example.globalVariables.*;

import java.io.IOException;

public class test_DB_data {

    public static void main(String[] args)  throws IOException {

        DerbyDatabase_Handler_data handler = new DerbyDatabase_Handler_data(SystemInfo.databaseName_data);
        CSV_Handler_data csvFileHandle = new CSV_Handler_data("ansonc");
        DerbyTable_Handler_data tableHandler = new DerbyTable_Handler_data(handler,"ANSONC");


      //  We define a class for storing data records in a linkedhashmap.

        // step 1a:  Read records from CSV and store them in a LinkedHashMap
        List_Handler_data recordSetHandler = csvFileHandle.CSV2RecordSet();
        recordSetHandler.printRecordSet();

        // step 1b: copy records from hashmap to DB
        tableHandler.RecordSet2Derby(recordSetHandler);

        System.out.println("\n");
        tableHandler.printMembers();  // print the records in the database's table

        // step 2a: copy records from DB to hashmap
        List_Handler_data retrieveRS = tableHandler.Derby2RecordSet();

        System.out.println("\n");
        retrieveRS.printRecordSet();  // print the records in the database's table

        // step 2b: copy records from hashmap to a csv file

        csvFileHandle.RecordSet2CSV(recordSetHandler);


    }
}
