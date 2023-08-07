package org.example;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        DerbyDatabaseHandler handler = new DerbyDatabaseHandler();
        DerbyTableHandler tableHandler = new DerbyTableHandler();

        handler = DerbyDatabaseHandler.getHandler();
//        tableHandler.createTable(handler);  // only need to create once.

        tableHandler.addMember(handler,"100","4an72");
        tableHandler.printMembers(handler);




    }
}