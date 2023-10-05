package com.example.database;

import com.example.globalVariables.StaticGlobalVariables;

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


    public double returnAverage(int choice){
        double sum = 0;
        ListIterator iterator = recordSet.listIterator();
        int k = Math.min(recordSet.size(),5);
        for (int j = 1; j < k+1; j++){
            Record_data temp1 = (Record_data) iterator.next();
            String[] temp = temp1.getRecord();
            sum = sum + Double.valueOf(temp[choice]);
        }

        Double out = sum/k;
        out = Math.round(out*100)/100.0;

        return out;
    }


}
