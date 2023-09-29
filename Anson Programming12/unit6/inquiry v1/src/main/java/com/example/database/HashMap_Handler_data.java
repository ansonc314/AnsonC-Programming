package com.example.database;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * This class is for storing records in a map format
 */
public class HashMap_Handler_data {
    public LinkedHashMap<String, Record_data> recordSet = new LinkedHashMap<String, Record_data>();


    /**
     * Default constructor
     */
    public HashMap_Handler_data(){
    }

    /**
     Add a recordUser to the LinkedHashMap (the newest entry is the first entry
     */
    public void addRecord(Record_data recordUser){
        LinkedHashMap<String, Record_data> newRecordSet = new LinkedHashMap<String, Record_data>();
        newRecordSet.put(recordUser.getKey(), recordUser);
        Iterator<String> iterator = recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record_data temp = recordSet.get(iterator.next());
            newRecordSet.put(temp.getKey(), temp);
        }
        recordSet = newRecordSet;
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
        System.out.println("Print from Record_data Set");
        Iterator<String> iterator = recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record_data temp = recordSet.get(iterator.next());
            temp.printRecordValue();
        }

    }
}
