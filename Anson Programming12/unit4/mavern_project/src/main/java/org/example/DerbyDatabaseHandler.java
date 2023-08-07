package org.example;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DerbyDatabaseHandler {

    private static final String DB_url = "jdbc:derby:database/loginDB;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    public static DerbyDatabaseHandler handler;

    public DerbyDatabaseHandler() {
        createConnection();
        createTable();
    }

    public static DerbyDatabaseHandler getHandler(){
        if(handler == null){
            handler = new DerbyDatabaseHandler();
            return handler;
        }else{
            return handler;
        }
    }

    private void createTable() {
        String TABLE_NAME = "MEMBER2";
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, TABLE_NAME, null);
            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + " exists");
            } else {
                String statement = "CREATE TABLE " + TABLE_NAME + " ("
                        + "id varchar(200) primary key, \n"
                        + "name varchar(200), \n"
                        + "email varchar(200), \n"
                        + "nickname varchar(200))";
                System.out.println(statement);
                stmt.execute(statement);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
