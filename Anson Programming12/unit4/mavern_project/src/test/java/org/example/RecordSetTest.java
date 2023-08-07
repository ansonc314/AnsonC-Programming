package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecordSetTest {

    @Test
    public void addRecord() {
        RecordSet myRecords = new RecordSet();

        myRecords.addRecord(new Record(new String[]{"abc","12ww"}));
        myRecords.addRecord(new Record(new String[]{"axc","12ww"}));
        myRecords.printRecordSet();  // hashmaps

    }
}