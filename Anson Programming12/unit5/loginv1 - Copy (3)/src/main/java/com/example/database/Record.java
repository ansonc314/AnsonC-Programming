package com.example.database;
import com.example.globalVariables.*;

public class Record {

    private String[] recordValue = new String[RecordInfo.noHeader];

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
           out  = out +  RecordInfo.header[k]   + ": " +recordValue[k]+ "\t\t" ;
        }
        return out;
    }

    public String[]  getRecord(){
        String[] out  = recordValue;
        return out;
    }

    public String getKey(){ // by default, the first entry of the record is the key
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
