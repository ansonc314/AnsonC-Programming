package com.example.database;

import java.sql.*;

public class DerbyDatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/loginDB;create=true";
    public static Connection conn = null;
    public static Statement stmt = null;
    public static DerbyDatabaseHandler handler;

    public DerbyDatabaseHandler() {
        createConnection();
        //createTable();
    }

    public static DerbyDatabaseHandler getHandler(){
        if(handler == null){
            handler = new DerbyDatabaseHandler();
            return handler;
        }else{
            return handler;
        }
    }


    private void createConnection() {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    public boolean execAction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;

        } catch (SQLException throwables) {
            System.out.println(throwables);
            System.out.println("Did not enter data");
        }
        return false;
    }
    public ResultSet execQuery(String query){
        ResultSet resultSet;
        try{
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return resultSet;
    }
}
