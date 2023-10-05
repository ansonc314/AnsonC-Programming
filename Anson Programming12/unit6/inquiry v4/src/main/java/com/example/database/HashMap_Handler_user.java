package com.example.database;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * This class is for storing records in a map format
 */
public class HashMap_Handler_user {
    public LinkedHashMap<String, Record_user> recordSet = new LinkedHashMap<String, Record_user>();


    /**
     * Default constructor
     */
    public HashMap_Handler_user(){
    }

    /**
     Add a recordUser to the LinkedHashMap
     */
    public void addRecord(Record_user recordUser){
       recordSet.put(recordUser.getKey(), recordUser);
    }

    /**
     delete a record from the LinkedHashMap
     */
    public void deleteRecord(String key){
        recordSet.remove(key);
    }

    /**
     * Print all records in the set
     */
    public void printRecordSet(){
        System.out.println("Print from Record_user Set");
        Iterator<String> iterator = recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record_user temp = recordSet.get(iterator.next());
            temp.printRecordValue();
        }

    }
}
