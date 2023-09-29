package com.example.database;

import com.example.globalVariables.RecordInfo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ListIterator;

/**
 * This class is used to handle read/write to the csv file which contains the user's records
 */
public class CSV_Handler_data {
    private String CSV_FILENAME;  // csv file name.
       
    /**
     * Constructor
     * @param filename  of the .csv file
     */
    public CSV_Handler_data(String filename){  // only file name, not extension
        CSV_FILENAME = "./" + filename +".csv";
    }


    /**
     * This method is to read the records from the csv file to List_Handler_data, which
     * contains a LinkedHashMap for storing all records
     * @return List_Handler_data
     * @throws IOException
     */
    public List_Handler_data CSV2RecordSet()   throws IOException {
        List_Handler_data listHandler = new List_Handler_data();
        Reader reader = Files.newBufferedReader(Paths.get(CSV_FILENAME));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader(RecordInfo.header_data[0],  RecordInfo.header_data[1],  RecordInfo.header_data[2], RecordInfo.header_data[3])
                .withIgnoreHeaderCase()
                .withTrim());


        for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names (defined in RecordInfo.header_data[]) assigned to each column
            String entry0 = csvRecord.get(RecordInfo.header_data[0]);
            String entry1 = csvRecord.get(RecordInfo.header_data[1]);
            String entry2 = csvRecord.get(RecordInfo.header_data[2]);
            String entry3 = csvRecord.get(RecordInfo.header_data[3]);

            listHandler.recordSet.add(new Record_data(new String[]{entry0,entry1,entry2,entry3}));
        }
        // delete the first entry in the listHandler, which is the header_data rows in the .csv file
        // note also that the listHandler does not store the header_data name
        listHandler.recordSet.remove();
        return listHandler;
    }

    /**
     * This method is to write the records in List_Handler_data to the csv file
     * @param handler  - a List_Handler_data object containing a LinkedHashMap of records.
     * @throws IOException
     */
    public void RecordSet2CSV(List_Handler_data handler) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILENAME));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

        // write the header_data row in the csv file
        csvPrinter.printRecord(RecordInfo.header_data[0],RecordInfo.header_data[1],RecordInfo.header_data[2] ,RecordInfo.header_data[3] );

        // write the records in the List_Handler_data into the .csv file

        ListIterator iterator = handler.recordSet.listIterator();

        while (iterator.hasNext()){
            Record_data temp = (Record_data) iterator.next();
            csvPrinter.printRecord(temp.getRecord()[0], temp.getRecord()[1], temp.getRecord()[2], temp.getRecord()[3]);
        }
        csvPrinter.flush();


    }

}
