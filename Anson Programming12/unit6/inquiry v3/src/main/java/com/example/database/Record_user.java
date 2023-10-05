package com.example.database;
import com.example.globalVariables.*;

public class Record_user {
    // username
    // password
    // fullname
    // height


    private String[] recordValue = new String[RecordInfo.noHeader_user];

    /**
     * Constructor
     * @param recordValue : this is a string array for storing the record values.
     */
    public Record_user(String[] recordValue) {
        setRecordValue(recordValue);
    }

    public String toString(){
        String out = "";
        for (int k = 0; k< RecordInfo.noHeader_user; k++){
           out  = out +  RecordInfo.header_user[k]   + ": " +recordValue[k]+ "\t\t" ;
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
        for (int k = 0; k< RecordInfo.noHeader_user; k++){
            this.recordValue[k] = recordValue[k];
        }
    }

    public void printRecordValue(){
        System.out.println(this.toString());
    }


}
