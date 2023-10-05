package com.example.database;

import com.example.globalVariables.RecordInfo;
import com.example.globalVariables.StaticGlobalVariables;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ListIterator;

public class DerbyTable_Handler_data {
    DerbyDatabase_Handler_data handler;
    String tableName ;


    /**
     * default constructor
     * @param handler - handler of a database
     * table_name is defined in the class SystemInfo
     */
    public DerbyTable_Handler_data(DerbyDatabase_Handler_data handler, String tableName){
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
                String entry0 = resultSet.getString(RecordInfo.header_data[0]);
                String entry1 = resultSet.getString(RecordInfo.header_data[1]);
                String entry2 = resultSet.getString(RecordInfo.header_data[2]);
                String entry3 = resultSet.getString(RecordInfo.header_data[3]);
                System.out.println(
                         RecordInfo.header_data[0]+ ": " + entry0 + "\t  "
                        + RecordInfo.header_data[1]+ ": " + entry1 + "\t  "
                        + RecordInfo.header_data[2]+ ": " + entry2 + "\t  "
                        + RecordInfo.header_data[3]+ ": " + entry3
                );
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
     * @param handler  - an RecordSetHandler object which contains a Hashed Map for storing data records.
     */
    public void RecordSet2Derby(List_Handler_data handler){
        // We first delete the table, and then write the records to the database from scratch

        deleteTable();
        ListIterator iterator = handler.recordSet.listIterator();
        while (iterator.hasNext()){
            Record_data temp = (Record_data) iterator.next();
            addMember(temp.getRecord()[0], temp.getRecord()[1], temp.getRecord()[2], temp.getRecord()[3] );
        }

    }

    /**
     * This method is used to copy the records in the database
     * to the LinkedHashMap in the recordSet
     * @return RecordSetHandler
     */
    public List_Handler_data Derby2RecordSet()  {
        List_Handler_data recordSet = new List_Handler_data();

        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu); // extract all records from the database

        // loop through the resultSet and add each record to the LinkedHashMap in the recordSet
        try{
            while(resultSet.next()){
                String entry0 = resultSet.getString(RecordInfo.header_data[0]);
                String entry1 = resultSet.getString(RecordInfo.header_data[1]);
                String entry2 = resultSet.getString(RecordInfo.header_data[2]);
                String entry3 = resultSet.getString(RecordInfo.header_data[3]);

                recordSet.recordSet.add(new Record_data(new String[]{entry0,entry1,entry2,entry3}));

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
                String entry0 = resultSet.getString(RecordInfo.header_data[0]);
                String entry1 = resultSet.getString(RecordInfo.header_data[1]);
                String entry2 = resultSet.getString(RecordInfo.header_data[2]);
                String entry3 = resultSet.getString(RecordInfo.header_data[3]);
                if (entry0.equals(username) && entry1.equals(password)){
                    flag = true;
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
                        + RecordInfo.header_data[0] + " varchar(200) primary key, \n"
                        + RecordInfo.header_data[1] + " varchar(200), \n"
                        + RecordInfo.header_data[2] + " varchar(200), \n"
                        + RecordInfo.header_data[3] + " varchar(200) )";
                System.out.println(statement);
                handler.stmt.execute(statement);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}