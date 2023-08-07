package org.example;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        DerbyDatabaseHandler handler = new DerbyDatabaseHandler();
        DerbyTableHandler tableHandler = new DerbyTableHandler();

        RecordSet myRecords = new RecordSet();

        myRecords.addRecord(new Record(new String[]{"abc","12ww"}));
        myRecords.addRecord(new Record(new String[]{"axc","12ww"}));
        myRecords.printRecordSet();  // hashmaps

        handler = DerbyDatabaseHandler.getHandler();
//        tableHandler.createTable(handler);  // only need to create once.

        tableHandler.addMember(handler,"107","4an72");
        tableHandler.printMembers(handler);




    }
}