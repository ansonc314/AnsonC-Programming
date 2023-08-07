package org.example;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args)  throws IOException {

        csvHandle csvFileHandle = new csvHandle();
        RecordSet recordSet = csvFileHandle.ReadFromCSV2RecordSet();


        DerbyDatabaseHandler handler = new DerbyDatabaseHandler();
        DerbyTableHandler tableHandler = new DerbyTableHandler(handler);

//        handler = DerbyDatabaseHandler.getHandler();
//        tableHandler.createTable(handler);  // only need to create once.

        tableHandler.RecordSet2Derby(recordSet);
        tableHandler.printMembers();

        RecordSet retr = tableHandler.Derby2RecordSet();
        retr.printRecordSet();





    }
}