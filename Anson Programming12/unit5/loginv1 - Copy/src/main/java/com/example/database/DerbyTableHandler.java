package com.example.database;

import com.example.globalVariables.RecordInfo;
import com.example.globalVariables.SystemInfo;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class DerbyTableHandler {
    DerbyDatabaseHandler handler;
    String tableName ;

    public DerbyTableHandler(DerbyDatabaseHandler handler){
        this.handler = handler;
        tableName = SystemInfo.databaseTableName;
        createTable();
    }

    public DerbyTableHandler(DerbyDatabaseHandler handler, String tableName){
        this.handler = handler;
        this.tableName = tableName;
        createTable();
    }


    /**
     *
     * @param entry0
     * @param entry1
     * @param entry2
     */
    public void addMember(String entry0, String entry1, String entry2){
        String qu = "INSERT INTO " + this.tableName+  " VALUES (" +
                "'" + entry0 + "'," +
                "'" + entry1 + "'," +
                "'" + entry2  + "')";
        handler.execAction(qu);

    }

    public  void printMembers(){
        System.out.println("Print from Derby Database");
        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);
        try{
            while(resultSet.next()){
                String entry0 = resultSet.getString(RecordInfo.header[0]);
                String entry1 = resultSet.getString(RecordInfo.header[1]);
                String entry2 = resultSet.getString(RecordInfo.header[2]);
                System.out.println(RecordInfo.header[0]+ ": " + entry0 + "\t  " + RecordInfo.header[1]+ " " + entry1 + "\t  " + RecordInfo.header[2]+ " " + entry2);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public void deleteTable(){
        String qu = "DELETE FROM " + this.tableName;
        handler.execAction(qu);
    }


    public void RecordSet2Derby(RecordSetHandler input){
        deleteTable();
        Iterator<String> iterator = input.recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record temp = input.recordSet.get(iterator.next());
            addMember(temp.getRecord()[0], temp.getRecord()[1], temp.getRecord()[2] );
        }

    }

    public RecordSetHandler Derby2RecordSet()  {
        RecordSetHandler recordSet = new RecordSetHandler();

        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);

        try{
            while(resultSet.next()){
                String entry0 = resultSet.getString(RecordInfo.header[0]);
                String entry1 = resultSet.getString(RecordInfo.header[1]);
                String entry2 = resultSet.getString(RecordInfo.header[2]);
                recordSet.addRecord(new Record(new String[]{entry0,entry1,entry2}));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recordSet;
    }

    public boolean recordExist(String username, String password){
        // select all the records and verify if a given username and password exists or not.
        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);

        Boolean flag = false;
        try{
            while(resultSet.next()){
                String entry0 = resultSet.getString(RecordInfo.header[0]);
                String entry1 = resultSet.getString(RecordInfo.header[1]);
                if (entry0.equals(username) && entry1.equals(password)){
                    flag = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;
    }


    public void createTable(){
        try {
            handler.stmt = handler.conn.createStatement();
            DatabaseMetaData dmn = handler.conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, this.tableName, null);
            if (tables.next()) {
                System.out.println("Table " + this.tableName + " exists");
            } else {
                String statement = "CREATE TABLE " + this.tableName + " ("
                        + RecordInfo.header[0] + " varchar(200) primary key, \n"
                        + RecordInfo.header[1] + " varchar(200), \n"
                        + RecordInfo.header[2] + " varchar(200) )";
                System.out.println(statement);
                handler.stmt.execute(statement);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
