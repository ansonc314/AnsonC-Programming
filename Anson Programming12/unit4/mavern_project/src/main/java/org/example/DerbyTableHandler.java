package org.example;
import org.globalVariables.RecordInfo;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
public class DerbyTableHandler {
    DerbyDatabaseHandler handler;
    String tableName ;

    /**
     * default constructor
     * @param handler - handler of a database
     */
    public DerbyTableHandler(DerbyDatabaseHandler handler){
        this.handler = handler;
        tableName = "TABLEPRODUCT";  // default table name TABLEPRODUCT
        createTable();
    }

    /**
     * Constructor with user-input table name
     * @param handler
     * @param tableName
     */
    public DerbyTableHandler(DerbyDatabaseHandler handler, String tableName){
        this.handler = handler;
        this.tableName = tableName;
        createTable();
    }


    /**
     * add a record (with 2 entries) to the table
     * @param entry0
     * @param entry1
     */
    public void addMember(String entry0, String entry1){
        String qu = "INSERT INTO " + this.tableName+  " VALUES (" +
                "'" + entry0 + "'," +
                "'" + entry1  + "')";
        handler.execAction(qu);

    }


    /**
     * Print all records in the table
     */
    public  void printMembers(){
        System.out.println("Print from Derby Database");
        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);
        try{
            while(resultSet.next()){
                String entry0 = resultSet.getString(RecordInfo.header[0]);
                String entry1 = resultSet.getString(RecordInfo.header[1]);
                System.out.println(RecordInfo.header[0]+ ": " + entry0 + "\t  " + RecordInfo.header[1]+ ": " + entry1);
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
    public void RecordSet2Derby(RecordSetHandler input){
        // We first delete the table, and then write the records to the database from scratch
        deleteTable();
        Iterator<String> iterator = input.recordSet.keySet().iterator();

        while (iterator.hasNext()){
            Record temp = input.recordSet.get(iterator.next());
            addMember(temp.getRecord()[0], temp.getRecord()[1]);
        }

    }

    /**
     * This method is used to copy the records in the database
     * to the LinkedHashMap in the RecordSetHandler
     * @return RecordSetHandler
     */
    public RecordSetHandler Derby2RecordSet()  {
        RecordSetHandler recordSet = new RecordSetHandler();

        String qu = "SELECT * FROM " + this.tableName ;
        ResultSet resultSet = handler.execQuery(qu);

        try{
            while(resultSet.next()){
                String entry0 = resultSet.getString(RecordInfo.header[0]);
                String entry1 = resultSet.getString(RecordInfo.header[1]);
                recordSet.addRecord(new Record(new String[]{entry0,entry1}));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recordSet;
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
                System.out.println("The table " + this.tableName + " exists");
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
