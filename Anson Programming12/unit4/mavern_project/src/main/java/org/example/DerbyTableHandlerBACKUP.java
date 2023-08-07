package org.example;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DerbyTableHandlerBACKUP {

    String tableName = "testTable1";
    public DerbyTableHandlerBACKUP(){

    }


    public void addMember(DerbyDatabaseHandler handler, String id, String name, String email, String nickName){
        String qu = "INSERT INTO " + this.tableName+  " VALUES (" +
                "'" + id + "'," +
                "'" + name + "'," +
                "'" + email + "'," +
                "'" + nickName + "')";
        handler.execAction(qu);

    }

    public  void printMembers(DerbyDatabaseHandler handler){
        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);
        try{
            while(resultSet.next()){
                String id = resultSet.getString("ID");
                String name = resultSet.getString("NAME");
                System.out.println("Entry: ID" + id + "\tName: " + name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public void createTable(DerbyDatabaseHandler handler){
//        String TABLE_NAME = "MEMBER2";
        try {
            handler.stmt = handler.conn.createStatement();
            DatabaseMetaData dmn = handler.conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, this.tableName, null);
            if (tables.next()) {
                System.out.println("Table " + this.tableName + " exists");
            } else {
                String statement = "CREATE TABLE " + this.tableName + " ("
                        + "id varchar(200) primary key, \n"
                        + "name varchar(200), \n"
                        + "email varchar(200), \n"
                        + "nickname varchar(200))";
                System.out.println(statement);
                handler.stmt.execute(statement);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
