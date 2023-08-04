package com.zaremba.databases;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static DatabaseHandler handler;

    /**
     * Add a record to the database (handler)
     * @param id
     * @param name
     * @param email
     * @param nickName
     */
    public static void addMember(String id, String name, String email, String nickName){
        String qu = "INSERT INTO MEMBER VALUES (" +
                "'" + id + "'," +
                "'" + name + "'," +
                "'" + email + "'," +
                "'" + nickName + "')";
        handler.execAction(qu);
    }
    public static void main(String[] args) {
        if(handler == null){
            System.out.println("null");
        }
        handler = new DatabaseHandler();
//handler.getClass();
        //        System.out.println(handler.toString());
//        handler = DatabaseHandler.getHandler();
/**
        addMember("322434","sg2fdsg","sdfsdf2sgf","sdf2fdsgs");
        String qu = "SELECT * FROM MEMBER";
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
*/

    }
}
