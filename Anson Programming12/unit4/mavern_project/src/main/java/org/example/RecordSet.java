package org.example;

import org.globalVariables.RecordInfo;

import java.util.*;

/**
 * This class is for storing records in a map format
 */
public class RecordSet {
    public LinkedHashMap<String, Record > recordSet = new LinkedHashMap<String, Record >();
    /* the first parameter is the key - the first entry of the Record to be stored
     */

    public RecordSet(){

    }
    public void addRecord(Record record){
       recordSet.put(record.getKey(),record);
    }

    public void deleteRecord(String key){
        recordSet.remove(key);
    }


    public void printRecordSet(){
        Iterator<String> iterator = recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record temp = recordSet.get(iterator.next());
            temp.printRecordValue();
        }

    }
}
