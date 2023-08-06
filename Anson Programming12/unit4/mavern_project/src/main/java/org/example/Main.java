package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String[] v = new String[2];
        v[0] = "abc";
        v[1] = "xyz";
        Record r = new Record(v);

        v[0] = "DEF";
        v[1] = "ERT";
        Record s = new Record(v);

        RecordSet myRecords = new RecordSet();
        myRecords.addRecord(r);
        myRecords.addRecord(s);
        myRecords.deleteRecord("abc");
        myRecords.printRecordSet();



    }
}