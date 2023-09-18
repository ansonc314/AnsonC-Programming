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

public class CSV_Handler {
    private String SAMPLE_CSV_FILE_NAME;  // the path and file name of the csv file

    /**
     * Constructor - Default
     */
    public CSV_Handler(){
        SAMPLE_CSV_FILE_NAME = "./productTableCSV.csv";
        // default filename is productTableCSV.csv
    }

    /**
     * Constructor
     * @param filename  of the .csv file
     */
    public CSV_Handler(String filename){  // only file name, not extension
        SAMPLE_CSV_FILE_NAME = "./" + filename +".csv";
    }

    /**
     * This method is to read the records from the csv file to RecordSetHandler, which
     * contains a LinkedHashMap for storing all records
     * @return RecordSetHandler
     * @throws IOException
     */
    public RecordSetHandler CSV2RecordSet()   throws IOException {
        RecordSetHandler recordSet = new RecordSetHandler();

        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_NAME));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader(RecordInfo.header[0],  RecordInfo.header[1])
                .withIgnoreHeaderCase()
                .withTrim());

        for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names (defined in RecordInfo.header[]) assigned to each column
            String entry0 = csvRecord.get(RecordInfo.header[0]);
            String entry1 = csvRecord.get(RecordInfo.header[1]);
            recordSet.addRecord(new Record(new String[]{entry0,entry1}));
        }
        // delete the first entry in the recordSet, which is the header rows in the .csv file
        // note also that the recordSet does not store the header name
        recordSet.deleteRecord(RecordInfo.header[0]);
        return recordSet;
    }

    /**
     * This method is to write the records in RecordSetHandler to the csv file
     * @param input  - a RecordSetHandler object containing a LinkedHashMap of records.
     * @throws IOException
     */
    public void RecordSet2CSV(RecordSetHandler input) throws IOException {   // this will overwrite
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_NAME));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

        // write the header row in the csv file
        csvPrinter.printRecord(RecordInfo.header[0],RecordInfo.header[1]);

        // write the records in the RecordSetHandler into the .csv file
        Iterator<String> iterator = input.recordSet.keySet().iterator();
        while (iterator.hasNext()){
            Record temp = input.recordSet.get(iterator.next());
            csvPrinter.printRecord(temp.getRecord()[0], temp.getRecord()[1]);
        }
        csvPrinter.flush();

    }


}
