package com.example.safe;

import javafx.scene.control.ListView;
import java.io.*;

public class list_login_data {
    public String filename;
    public ListView<login> list = new ListView<login>();

    list_login_data(String input){
        this.filename = input;
    }


    public void read2list(String master) throws IOException {
        mixing rand = new mixing(master);

        list.getItems().clear();
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            String company = line;
            String account = br.readLine();
            String password = br.readLine();
            String website = br.readLine();

            login temp = new login(rand.unmix(company), rand.unmix(account), rand.unmix(password), rand.unmix(website));
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
            login temp = list.getItems().get(i);
            bw.write(rand.mix(temp.company) + "\r");
            bw.write(rand.mix(temp.account) + "\r");
            bw.write(rand.mix(temp.password) + "\r");
            bw.write(rand.mix(temp.website) + "\r");
        }
        bw.close();
    }


}
