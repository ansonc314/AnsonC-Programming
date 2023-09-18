package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecordTest {

    @Test
    public void addRecord() {

        RecordSetHandler myRecordSet = new RecordSetHandler();

        myRecordSet.addRecord(new Record(new String[]{"item1","first item"}));
        myRecordSet.addRecord(new Record(new String[]{"item2","second item"}));

        String[]  out = myRecordSet.recordSet.get("item1").getRecord();
        assertEquals( "item1", out[0]   );
        assertEquals( "first item", out[1]   );
        assertEquals(2,myRecordSet.recordSet.size());

    }
}