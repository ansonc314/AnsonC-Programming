package module2_5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Write2File {

    Write2File(){

    }
    public static void write2txt(String filename, ArrayList<String> lines) throws IOException {
        FileWriter fw = new FileWriter(filename);    // create FileReader and BufferedReader
        BufferedWriter bw = new BufferedWriter(fw);

        for (String s : lines){
            bw.write(s + "\n");
        }

        bw.close();
    }


}
