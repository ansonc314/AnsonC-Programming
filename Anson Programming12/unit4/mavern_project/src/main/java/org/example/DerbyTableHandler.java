package org.example;

import org.globalVariables.RecordInfo;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DerbyTableHandler {

    String tableName = "tableProduct";
    public DerbyTableHandler(){

    }


    public void addMember(DerbyDatabaseHandler handler, String product, String country){
        String qu = "INSERT INTO " + this.tableName+  " VALUES (" +
                "'" + product + "'," +
                "'" + country  + "')";
        handler.execAction(qu);

    }

    public  void printMembers(DerbyDatabaseHandler handler){
        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);
        try{
            while(resultSet.next()){
                String product = resultSet.getString(RecordInfo.header[0]);
                String country = resultSet.getString(RecordInfo.header[1]);
                System.out.println(RecordInfo.header[0]+ " " + product + "\t  " + RecordInfo.header[1]+ " " + country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public void createTable(DerbyDatabaseHandler handler){
        try {
            handler.stmt = handler.conn.createStatement();
            DatabaseMetaData dmn = handler.conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, this.tableName, null);
            if (tables.next()) {
                System.out.println("Table " + this.tableName + " exists");
            } else {
                String statement = "CREATE TABLE " + this.tableName + " ("
                        + RecordInfo.header[0] + " varchar(200) primary key, \n"
                        + RecordInfo.header[1] + " varchar(200))";
                System.out.println(statement);
                handler.stmt.execute(statement);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
