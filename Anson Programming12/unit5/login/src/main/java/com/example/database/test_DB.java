package com.example.database;

import com.example.globalVariables.*;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;

public class test_DB {

    public static void main(String[] args)  throws IOException {


        CSV_Handler csvFileHandle = new CSV_Handler("loginDatabase");
        DerbyDatabaseHandler handler = new DerbyDatabaseHandler();
        DerbyTableHandler tableHandler = new DerbyTableHandler(handler);

       //  tableHandler.deleteTable();
       //  tableHandler.createTable();


        // test 1: CSV - ReSet - DB
        RecordSetHandler recordSetHandler = csvFileHandle.CSV2RecordSet(); // csv 2 recordSet
        tableHandler.RecordSet2Derby(recordSetHandler);  //RecordSet 2 DB
        tableHandler.printMembers();


        // test 2: DB - ReSET - CSV

        RecordSetHandler retr = tableHandler.Derby2RecordSet();  // read data from database to recordSet
        //csvFileHandle.RecordSet2CSV(retr);
        //retr.printRecordSet();

        /*
        String a = "xv";
        SimpleStringProperty b = new SimpleStringProperty(a);
        System.out.println(b);

         */
        String[] Sarray = new String[3];
        Sarray[0]="a";
        Sarray[1]="b";
        Sarray[2]="3";
        Record x = new Record(Sarray);
        SimpleStringRecord y = new SimpleStringRecord(Sarray);
        System.out.println(y.recordValue[2] );
    }
}
