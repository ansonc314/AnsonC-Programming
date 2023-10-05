package com.example.database;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class is for storing records in a map format
 */
public class List_Handler_data {
    public LinkedList<Record_data> recordSet = new LinkedList<Record_data>();


    /**
     * Default constructor
     */
    public List_Handler_data(){
    }

    /**
     Add a recordUser to the LinkedHashMap (the newest entry is the first entry
     */
    public void addRecord2First(Record_data recordUser){
        recordSet.add(0,recordUser);
    }


    /**
     * Print all records in the set
     */
    public void printRecordSet(){
        System.out.println("Print from Record_data Set");
        ListIterator iterator = recordSet.listIterator();
        while (iterator.hasNext()){
            System.out.println( iterator.next());

        }

    }
}
