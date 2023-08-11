package com.example.database;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * This class is for storing records in a map format
 */
public class RecordSetHandler {
    public LinkedHashMap<String, Record> recordSet = new LinkedHashMap<String, Record>();
    /* the first parameter is the key - the first entry of the Record to be stored
     */

    public RecordSetHandler(){

    }
    public void addRecord(Record record){
       recordSet.put(record.getKey(),record);
    }

    public void deleteRecord(String key){
        recordSet.remove(key);
    }


    public void printRecordSet(){
        System.out.println("Print from Record Set");

        Iterator<String> iterator = recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record temp = recordSet.get(iterator.next());
            temp.printRecordValue();
        }

    }
}
