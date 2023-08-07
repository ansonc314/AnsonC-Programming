package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class csvHandle {


    public void ReadFromCSV()   throws IOException {
        String SAMPLE_CSV_FILE_PATH = "./productTableCSV.csv";

        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("product",  "country")
                .withIgnoreHeaderCase()
                .withTrim());


        for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names assigned to each column
            String name = csvRecord.get("product");
            String email = csvRecord.get("country");

            System.out.println("Record No - " + csvRecord.getRecordNumber());
            System.out.println("---------------");
            System.out.println("Name : " + name);
            System.out.println("Email : " + email);
            System.out.println("---------------\n\n");
        }


    }

    public void Write2CSV() throws IOException {   // this will overwrite
        String SAMPLE_CSV_FILE_PATH = "./Write2productTableCSV.csv";
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader("ID", "Name", "Designation", "Company"));

        csvPrinter.printRecord("2", "Sundar Pichai", "CEO", "Google");

        csvPrinter.flush();

    }
}
