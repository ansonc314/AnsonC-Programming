package com.example.database;

import com.example.globalVariables.SystemInfo;

import java.sql.*;

public class DerbyDatabase_Handler_data {
    private String DB_url;
    public  Connection conn = null;
    public Statement stmt = null;
    public DerbyDatabase_Handler_data handler;


    /**
     * Create a database with user-defined databaseName_data
     * @param databaseName_data
     */
    public DerbyDatabase_Handler_data(String databaseName_data) {
        DB_url = "jdbc:derby:database/" + databaseName_data + ";create=true";
        createConnection();
    }



    /**
     * this method will create a connection to the database
     * the connection conn will be subsequently be used to execute action and query
     */
    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    /**
     * this method will execute a database action
     * @param qu - database query to be executed
     * @return boolean if execution is successful or not
     */
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

    /**
     * this method will execute a database query
     * @param query
     * @return ResultSet
     */
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
