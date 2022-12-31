package com.example.safe;

        import javafx.scene.control.ListView;
        import java.io.*;

public class list_notes_data {
    public String filename;
    public ListView<notes> list = new ListView<notes>();

    list_notes_data(String input){
        this.filename = input;
    }


    public void read2list(String master) throws IOException {
        mixing rand = new mixing(master);

        list.getItems().clear();
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            String title = line;
            String notetext = br.readLine();

            notes temp = new notes(rand.unmix(title), rand.unmix(notetext));
            list.getItems().add(temp);
        }
        br.close();
    }


    public void write2txt(String master) throws IOException {
        mixing rand = new mixing(master);

        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);

        int listsize = list.getItems().size();
        for (int i=0; i< listsize; i++) {
            notes temp = list.getItems().get(i);
            bw.write(rand.mix(temp.title) + "\r");
            bw.write(rand.mix(temp.notetext) + "\r");
        }
        bw.close();
    }


}
