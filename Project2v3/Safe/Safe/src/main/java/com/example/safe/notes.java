package com.example.safe;

public class notes {
    public String title;
    public String notetext;
    // Constructor
    notes(String title, String notetext) {
        this.title = title;
        this.notetext = notetext;
    }

    public String toString(){
        return this.title;
    }
}
