package com.example.database;

import com.example.globalVariables.StaticGlobalVariables;
import com.example.globalVariables.RecordInfo;
import com.example.globalVariables.SystemInfo;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class DerbyTable_Handler_user {
    DerbyDatabase_Handler_user handler;
    String tableName ;

    /**
     * default constructor
     * @param handler - handler of a database
     * table_name is defined in the class SystemInfo
     */
    public DerbyTable_Handler_user(DerbyDatabase_Handler_user handler){
        this.handler = handler;
        tableName = SystemInfo.databaseName_user;
        createTable();
    }

    /**
     * default constructor
     * @param handler - handler of a database
     * table_name is defined in the class SystemInfo
     */
    public DerbyTable_Handler_user(DerbyDatabase_Handler_user handler, String tableName){
        this.handler = handler;
        this.tableName = tableName;
        createTable();
    }


    /**
     * add a record (with 3 entries) to the table
     * @param entry0
     * @param entry1
     * @param entry2
     */
    public void addMember(String entry0, String entry1, String entry2, String entry3){
        String qu = "INSERT INTO " + this.tableName+  " VALUES (" +
                "'" + entry0 + "'," +
                "'" + entry1 + "'," +
                "'" + entry2 + "'," +
                "'" + entry3  + "')";
        handler.execAction(qu);

    }

    /**
     * Print all records in the table
     */
    public  void printMembers(){
        System.out.println("\nPrint from Derby Database");
        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);
        try{
            while(resultSet.next()){
                String entry0 = resultSet.getString(RecordInfo.header_user[0]);
                String entry1 = resultSet.getString(RecordInfo.header_user[1]);
                String entry2 = resultSet.getString(RecordInfo.header_user[2]);
                String entry3 = resultSet.getString(RecordInfo.header_user[3]);
                System.out.println(RecordInfo.header_user[0]+ ": " + entry0 + "\t  "
                        + RecordInfo.header_user[1]+ ": " + entry1 + "\t  "
                        + RecordInfo.header_user[2]+ ": " + entry2 + "\t  "
                        + RecordInfo.header_user[3]+ ": " + entry3);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    /**
     * delete the table
     */
    public void deleteTable(){
        String qu = "DELETE FROM " + this.tableName;
        handler.execAction(qu);
    }

    /**
     * This method is used to write the records in RecordSetHandler to the database
     * @param input  - an RecordSetHandler object which contains a Hashed Map for storing data records.
     */
    public void RecordSet2Derby(HashMap_Handler_user input){
        // We first delete the table, and then write the records to the database from scratch
        deleteTable();
        Iterator<String> iterator = input.recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record_user temp = input.recordSet.get(iterator.next());
            temp.printRecordValue();
            addMember(temp.getRecord()[0], temp.getRecord()[1], temp.getRecord()[2], temp.getRecord()[3] );
        }

    }

    /**
     * This method is used to copy the records in the database
     * to the LinkedHashMap in the recordSet
     * @return RecordSetHandler
     */
    public HashMap_Handler_user Derby2RecordSet()  {
        HashMap_Handler_user recordSet = new HashMap_Handler_user();

        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu); // extract all records from the database

        // loop through the resultSet and add each record to the LinkedHashMap in the recordSet
        try{
            while(resultSet.next()){
                String entry0 = resultSet.getString(RecordInfo.header_user[0]);
                String entry1 = resultSet.getString(RecordInfo.header_user[1]);
                String entry2 = resultSet.getString(RecordInfo.header_user[2]);
                String entry3 = resultSet.getString(RecordInfo.header_user[3]);
                recordSet.addRecord(new Record_user(new String[]{entry0,entry1,entry2,entry3}));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recordSet;
    }


    /**
     *
     * @param username
     * @param password
     * @return true if there exists a user with the given username and password
     */
    public boolean recordExist(String username, String password){
        // select all the records and verify if a given username and password exists or not.
        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);

        Boolean flag = false;
        // loop through the resultSet and check if there is match with the given user name and password
        try{
            while(resultSet.next()){
                String entry0 = resultSet.getString(RecordInfo.header_user[0]);
                String entry1 = resultSet.getString(RecordInfo.header_user[1]);
                String entry2 = resultSet.getString(RecordInfo.header_user[2]);
                String entry3 = resultSet.getString(RecordInfo.header_user[3]);
                if (entry0.equals(username) && entry1.equals(password)){
                    flag = true;
                    StaticGlobalVariables.currentUserID=entry0;
                    StaticGlobalVariables.currentHeight=entry3;
                    StaticGlobalVariables.currentUser = entry2;
                    StaticGlobalVariables.currentDataTableName=entry0.toUpperCase();
                    System.out.println("DATATABLE = "+StaticGlobalVariables.currentDataTableName);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;
    }


    /**
     * Create a table
     */
    public void createTable(){
        try {
            handler.stmt = handler.conn.createStatement();
            DatabaseMetaData dmn = handler.conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, this.tableName, null);

            // check if the table exists already
            if (tables.next()) {
                System.out.println("Table " + this.tableName + " exists");
            } else {
                String statement = "CREATE TABLE " + this.tableName + " ("
                        + RecordInfo.header_user[0] + " varchar(200) primary key, \n"
                        + RecordInfo.header_user[1] + " varchar(200), \n"
                        + RecordInfo.header_user[2] + " varchar(200), \n"
                        + RecordInfo.header_user[3] + " varchar(200) )";
                System.out.println(statement);
                handler.stmt.execute(statement);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
