package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        /**
         * https://www.youtube.com/watch?v=cFFLcjrcU8s
         */
        String jdbcURL = "jdbc:derby:loginDB;create=true";
        try{
            Connection connection = DriverManager.getConnection(jdbcURL);


//            String sql = "Create Table products (id int not null generated always as identity, "
//                            + "name varchar(128), price float)";

            String sql = "Insert into products (name,price) values ('iphone 12' ,200 )";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("A row created");
            }

        } catch (SQLException e){
                    e.printStackTrace();
        }




    }
}