package com.example.database;

import com.example.globalVariables.SystemInfo;

import java.io.IOException;

public class test_DB_user {

    public static void main(String[] args)  throws IOException {

        DerbyDatabase_Handler_user handler = new DerbyDatabase_Handler_user(SystemInfo.databaseName_user);

        CSV_Handler_user csvFileHandle = new CSV_Handler_user(SystemInfo.csvFilename_user);

        DerbyTable_Handler_user tableHandler = new DerbyTable_Handler_user(handler,SystemInfo.databaseTableName_user);


        /*
        We define a class for storing data records in a linkedhashmap.
        */
/*
        // step 1a:  Read records from CSV and store them in a LinkedHashMap
        HashMap_Handler_user recordSetHandler = csvFileHandle.CSV2RecordSet();

        // step 1b: copy records from hashmap to DB
        tableHandler.RecordSet2Derby(recordSetHandler);

        System.out.println("\n");
        tableHandler.printMembers();  // print the records in the database's table

        // step 2a: copy records from DB to hashmap
        HashMap_Handler_user retrieveRS = tableHandler.Derby2RecordSet();

        System.out.println("\n");
        retrieveRS.printRecordSet();  // print the records in the database's table

        // step 2b: copy records from hashmap to a csv file
        csvFileHandle.RecordSet2CSV(retrieveRS);


 */

    }
}
