package org.example;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  throws IOException {

        CSV_Handler csvFileHandle = new CSV_Handler("productTableCSV"); // This object will handle read/write of the csv files
        DerbyDatabaseHandler DBhandler = new DerbyDatabaseHandler("productDB"); // this object defines the database handler
        DerbyTableHandler tableHandler = new DerbyTableHandler(DBhandler,"APPLEPRODUCT");  // this object will handle read/write of the tables



        /*
        We define a class for storing data records in a linkedhashmap.
        */

        // step 1a:  Read records from CSV and store them in a LinkedHashMap
        RecordSetHandler recordSetHandler = csvFileHandle.CSV2RecordSet();

        // step 1b: copy records from hashmap to DB
        tableHandler.RecordSet2Derby(recordSetHandler);

        System.out.println("\n");
        tableHandler.printMembers();  // print the records in the database's table

        // step 2a: copy records from DB to hashmap
        RecordSetHandler retrieveRS = tableHandler.Derby2RecordSet();

        System.out.println("\n");
        retrieveRS.printRecordSet();  // print the records in the database's table

        // step 2b: copy records from hashmap to a csv file
        csvFileHandle.RecordSet2CSV(retrieveRS);

    }
}