package org.example;
import java.util.*;

/**
 * This class is for storing records in a LinkedHashMap
 */
public class RecordSetHandler {
    public LinkedHashMap<String, Record > recordSet = new LinkedHashMap<String, Record >();

    /**
     * Default constructor
     */
    public RecordSetHandler(){
    }

    /**
    Add a record to the LinkedHashMap
     */
    public void addRecord(Record record){
       recordSet.put(record.getKey(),record);
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
        System.out.println("Print from Record Set");
        Iterator<String> iterator = recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record temp = recordSet.get(iterator.next());
            temp.printRecordValue();
        }

    }
}
