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

public class CSV_Handler {
    private String SAMPLE_CSV_FILE_PATH;

    /**
     * Constructor - Default
     */
    public CSV_Handler(){
        SAMPLE_CSV_FILE_PATH = "./loginDatabase.csv";
    }

    /**
     * Constructor
     * @param filename  of the .csv file
     */
    public CSV_Handler(String filename){  // only file name, not extension
        SAMPLE_CSV_FILE_PATH = "./" + filename +".csv";
    }



    public RecordSetHandler CSV2RecordSet()   throws IOException {
        RecordSetHandler recordSet = new RecordSetHandler();

        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader(RecordInfo.header[0],  RecordInfo.header[1],  RecordInfo.header[2])
                .withIgnoreHeaderCase()
                .withTrim());


        for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names assigned to each column
            String entry0 = csvRecord.get(RecordInfo.header[0]);
            String entry1 = csvRecord.get(RecordInfo.header[1]);
            String entry2 = csvRecord.get(RecordInfo.header[2]);
            recordSet.addRecord(new Record(new String[]{entry0,entry1,entry2}));
        }
        recordSet.deleteRecord(RecordInfo.header[0]);  // delete the header entry
        return recordSet;
    }

    public void RecordSet2CSV(RecordSetHandler input) throws IOException {   // this will overwrite
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));

        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

        csvPrinter.printRecord(RecordInfo.header[0],RecordInfo.header[1],RecordInfo.header[2]); // add header row

        Iterator<String> iterator = input.recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record temp = input.recordSet.get(iterator.next());

            csvPrinter.printRecord(temp.getRecord()[0], temp.getRecord()[1], temp.getRecord()[2]);
        }

        csvPrinter.flush();

    }


}
