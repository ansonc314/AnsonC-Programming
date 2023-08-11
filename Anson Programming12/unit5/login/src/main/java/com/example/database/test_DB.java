package com.example.database;

import com.example.globalVariables.*;
import java.io.IOException;

public class test_DB {

    public static void main(String[] args)  throws IOException {


        CSV_Handler csvFileHandle = new CSV_Handler();
        DerbyDatabaseHandler handler = new DerbyDatabaseHandler();
        DerbyTableHandler tableHandler = new DerbyTableHandler(handler);

        //tableHandler.createTable();


        // test 1: CSV - ReSet - DB
        RecordSetHandler recordSetHandler = csvFileHandle.CSV2RecordSet(); // csv 2 recordSet
        tableHandler.RecordSet2Derby(recordSetHandler);  //RecordSet 2 DB
        tableHandler.printMembers();


        // test 2: DB - ReSET - CSV

        RecordSetHandler retr = tableHandler.Derby2RecordSet();
        csvFileHandle.RecordSet2CSV(retr);
        retr.printRecordSet();


    }
}
