package com.example.database;
import com.example.globalVariables.*;
import javafx.beans.property.SimpleStringProperty;

public class Record {

//    private int valueSize = RecordInfo.noHeader;
    private String[] recordValue = new String[RecordInfo.noHeader];  // fields in each record
    private String key;

    /**
     * Constructor
     * @param recordValue : this is a string array for storing the record values.
     */
    public Record(String[] recordValue) {
        setRecordValue(recordValue);
    }

    public String toString(){
        String out = "";
        for (int k= 0; k< RecordInfo.noHeader; k++){
           out  = out +  RecordInfo.header[k]   + " is equal to " +recordValue[k]+ "        " ;
        }
        return out;
    }

    public String[]  getRecord(){
        String[] out  = recordValue;
        return out;
    }

    public String getKey(){
        return recordValue[0];
    }

    public void setRecordValue(String[] recordValue) {
        for (int k= 0; k< RecordInfo.noHeader; k++){
            this.recordValue[k] = recordValue[k];
        }
    }

    public void printRecordValue(){
        System.out.println(this.toString());
    }


}
