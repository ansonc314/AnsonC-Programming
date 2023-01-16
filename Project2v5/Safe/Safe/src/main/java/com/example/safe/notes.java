package com.example.safe;

public class notes {
    public String title;
    public String notetext;

    // Constructor
    notes(String title, String notetext) {
        set_title(title);
        set_notetext(notetext);
    }

    public void set_title(String title) {
        /*
        Requires: String title
        Modifies: this.title
        Effects: set title
         */
        this.title = title;
    }

    public void set_notetext(String notetext) {
        /*
        Requires: String notetext
        Modifies: this.notetext
        Effects: set notetext
         */
        this.notetext = notetext;
    }

    public String get_title() {
        /*
        Effects: return note title
         */
        return this.title;
    }

    public String get_notetext() {
        /*
        Effects: return note text
         */
        return this.notetext;
    }




    public String toString(){
        return this.title;
    }
}
