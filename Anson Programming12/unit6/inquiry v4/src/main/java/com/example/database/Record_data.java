package com.example.database;

import com.example.globalVariables.RecordInfo;

public class Record_data {
    // https://www.registerednursern.com/bmi-calculation-formula-explained/
    // BMI = weight (kg) / height (m)^2
    // weight
    // SystolicBP
    // DiastolicBP


    private String[] recordValue = new String[RecordInfo.noHeader_data];

    /**
     * Constructor
     * @param recordValue : this is a string array for storing the record values.
     */
    public Record_data(String[] recordValue) {
        setRecordValue(recordValue);
    }

    public String toString(){
        String out = "";
        for (int k = 0; k< RecordInfo.noHeader_data; k++){
           out  = out +  RecordInfo.header_data[k]   + ": " +recordValue[k]+ "\t\t" ;
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
        for (int k = 0; k< RecordInfo.noHeader_data; k++){
            this.recordValue[k] = recordValue[k];
        }
    }

    public void printRecordValue(){
        System.out.println(this.toString());
    }


}
