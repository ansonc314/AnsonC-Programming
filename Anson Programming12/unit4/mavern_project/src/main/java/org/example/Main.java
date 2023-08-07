package org.example;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Main {
    public static DerbyDatabaseHandler handler;

    public static void addMember(String id, String name, String email, String nickName){
        String qu = "INSERT INTO MEMBER2 VALUES (" +
                "'" + id + "'," +
                "'" + name + "'," +
                "'" + email + "'," +
                "'" + nickName + "')";
        handler.execAction(qu);
    }
    public static void main(String[] args) {
        RecordSet myRecords = new RecordSet();

        myRecords.addRecord(new Record(new String[]{"abc","12ww"}));
        myRecords.addRecord(new Record(new String[]{"axc","12ww"}));

        myRecords.printRecordSet();

        handler = DerbyDatabaseHandler.getHandler();
//        addMember("1","ans","sdfsdf2sgf","sdf2fdsgs");
        addMember("2","ans2","sdfsdf2sgf","sdf2fdsgs");

        String qu = "SELECT * FROM MEMBER2";
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
}