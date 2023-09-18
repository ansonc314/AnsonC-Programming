package org.example;
import org.globalVariables.*;
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
           out  = out +  RecordInfo.header[k]   + ":  " +recordValue[k]+ "        " ;
        }
        return out;
    }

    public String[]  getRecord(){
        String[] out  = recordValue;
        return out;
    }

    /**
     * @return the key of the record
     */
    public String getKey(){
        return recordValue[0];
    }

    /**
     *
     * @param recordValue
     * set recordValue
     */
    public void setRecordValue(String[] recordValue) {
        for (int k= 0; k< RecordInfo.noHeader; k++){
            this.recordValue[k] = recordValue[k];
        }
    }

    /*
    Print recordValue
     */
    public void printRecordValue(){
        System.out.println(this.toString());
    }


}
