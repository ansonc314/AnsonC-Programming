package com.example.database;

import com.example.globalVariables.RecordInfo;
import javafx.beans.property.SimpleStringProperty;

public class SimpleStringRecord {

    public SimpleStringProperty[] recordValue = new SimpleStringProperty[RecordInfo.noHeader];  // fields in each record

    /**
     * Constructor
     * @param recordValue : this is a string array for storing the record values.
     */
    public SimpleStringRecord(String[] recordValue) {
        setRecordValue(recordValue);
    }

    public void setRecordValue(String[] recordValue) {
        for (int k= 0; k< RecordInfo.noHeader; k++){
            this.recordValue[k] = new SimpleStringProperty((String) recordValue[k]);
        }
    }

}
