package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        RecordSet myRecords = new RecordSet();

        myRecords.addRecord(new Record(new String[]{"abc","12ww"}));
        myRecords.addRecord(new Record(new String[]{"axc","12ww"}));

        myRecords.printRecordSet();




    }
}