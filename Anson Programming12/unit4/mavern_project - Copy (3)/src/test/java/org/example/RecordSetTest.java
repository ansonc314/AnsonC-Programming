package org.example;

import org.junit.Test;

public class RecordSetTest {

    @Test
    public void addRecord() {
        RecordSetHandler myRecords = new RecordSetHandler();

        myRecords.addRecord(new Record(new String[]{"abc","12ww"}));
        myRecords.addRecord(new Record(new String[]{"axc","12ww"}));
        myRecords.printRecordSet();  // hashmaps

    }
}