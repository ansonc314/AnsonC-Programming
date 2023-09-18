package com.example.database;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import com.example.globalVariables.RecordInfo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * This class is used to handle read/write to the csv file which contains the user's records
 */
public class CSV_Handler {
    private String CSV_FILENAME;  // csv file name.


    /**
     * Constructor - Default
     */
    public CSV_Handler(){
        CSV_FILENAME = "./csvDatabase.csv";  // default csv filename is loginDatabase
    }

    /**
     * Constructor
     * @param filename  of the .csv file
     */
    public CSV_Handler(String filename){  // only file name, not extension
        CSV_FILENAME = "./" + filename +".csv";
    }


    /**
     * This method is to read the records from the csv file to RecordSet_Handler, which
     * contains a LinkedHashMap for storing all records
     * @return RecordSet_Handler
     * @throws IOException
     */
    public RecordSet_Handler CSV2RecordSet()   throws IOException {
        RecordSet_Handler recordSet = new RecordSet_Handler();
        Reader reader = Files.newBufferedReader(Paths.get(CSV_FILENAME));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader(RecordInfo.header[0],  RecordInfo.header[1],  RecordInfo.header[2])
                .withIgnoreHeaderCase()
                .withTrim());


        for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names (defined in RecordInfo.header[]) assigned to each column
            String entry0 = csvRecord.get(RecordInfo.header[0]);
            String entry1 = csvRecord.get(RecordInfo.header[1]);
            String entry2 = csvRecord.get(RecordInfo.header[2]);
            recordSet.addRecord(new Record(new String[]{entry0,entry1,entry2}));
        }
        // delete the first entry in the recordSet, which is the header rows in the .csv file
        // note also that the recordSet does not store the header name
        recordSet.deleteRecord(RecordInfo.header[0]);
        return recordSet;
    }

    /**
     * This method is to write the records in RecordSet_Handler to the csv file
     * @param input  - a RecordSet_Handler object containing a LinkedHashMap of records.
     * @throws IOException
     */
    public void RecordSet2CSV(RecordSet_Handler input) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILENAME));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

        // write the header row in the csv file
        csvPrinter.printRecord(RecordInfo.header[0],RecordInfo.header[1],RecordInfo.header[2]);

        // write the records in the RecordSet_Handler into the .csv file
        Iterator<String> iterator = input.recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record temp = input.recordSet.get(iterator.next());
            csvPrinter.printRecord(temp.getRecord()[0], temp.getRecord()[1], temp.getRecord()[2]);
        }
        csvPrinter.flush();
    }

}
