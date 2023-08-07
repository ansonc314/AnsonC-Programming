package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.globalVariables.RecordInfo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.HashMap;
public class csvHandle {
    private String SAMPLE_CSV_FILE_PATH;

    public csvHandle(){
        SAMPLE_CSV_FILE_PATH = "./productTableCSV.csv";
    }
    public csvHandle(String filename){  // only file name, not extension
        SAMPLE_CSV_FILE_PATH = "./" + filename +".csv";
    }




    public RecordSet ReadFromCSV2RecordSet()   throws IOException {
        RecordSet recordSet = new RecordSet();

        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader(RecordInfo.header[0],  RecordInfo.header[1])
                .withIgnoreHeaderCase()
                .withTrim());

        for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names assigned to each column
            String entry1 = csvRecord.get(RecordInfo.header[0]);
            String entry2 = csvRecord.get(RecordInfo.header[1]);
            recordSet.addRecord(new Record(new String[]{entry1,entry2}));
        }
        return recordSet;
    }

    public void RecordSetWrite2CSV(RecordSet input) throws IOException {   // this will overwrite
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));

        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

        Iterator<String> iterator = input.recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record temp = input.recordSet.get(iterator.next());
            csvPrinter.printRecord(temp.getRecord()[0], temp.getRecord()[1]);
            temp.printRecordValue();
        }

        csvPrinter.flush();

    }


}
