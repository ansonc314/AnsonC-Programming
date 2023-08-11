package com.example.database;

import com.example.globalVariables.RecordInfo;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class DerbyTableHandler {
    DerbyDatabaseHandler handler;
    String tableName ;

    public DerbyTableHandler(DerbyDatabaseHandler handler){
        this.handler = handler;
        tableName = "loginTable";
    }

    public DerbyTableHandler(DerbyDatabaseHandler handler, String tableName){
        this.handler = handler;
        this.tableName = tableName;
    }


    /**
     *
     * @param entry0
     * @param entry1
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
                System.out.println(RecordInfo.header[0]+ " " + entry0 + "\t  " + RecordInfo.header[1]+ " " + entry1 + "\t  " + RecordInfo.header[2]+ " " + entry2);
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
        input.recordSet.get(iterator.next());  // do not store the first header row in the database in the LinkedHashMap
        while (iterator.hasNext()){
            Record temp = input.recordSet.get(iterator.next());
            addMember(temp.getRecord()[0], temp.getRecord()[1], temp.getRecord()[2] );
        }

    }

    public RecordSetHandler Derby2RecordSet()  {
        RecordSetHandler recordSet = new RecordSetHandler();

        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);

        // add header to RecordSet
        String header_entry0 = RecordInfo.header[0];
        String header_entry1 = RecordInfo.header[1];
        String header_entry2 = RecordInfo.header[2];
        recordSet.addRecord(new Record(new String[]{header_entry0,header_entry1,header_entry2}));

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
