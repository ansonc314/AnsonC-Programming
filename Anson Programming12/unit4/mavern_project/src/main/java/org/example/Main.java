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
    // csvFileHandle.ReadFromCSV();
    csvFileHandle.Write2CSV();






        /*
        DerbyDatabaseHandler handler = new DerbyDatabaseHandler();
        DerbyTableHandler tableHandler = new DerbyTableHandler();

        handler = DerbyDatabaseHandler.getHandler();
//        tableHandler.createTable(handler);  // only need to create once.

        tableHandler.addMember(handler,"100","4an72");
        tableHandler.printMembers(handler);


 */



    }
}