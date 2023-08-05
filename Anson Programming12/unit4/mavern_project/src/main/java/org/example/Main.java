package org.example;

public class Main {
    public static void main(String[] args) {

        Record r = new Record("a", "b" ,"c" , "d" , "e");

        r.setRecord("a", "x" ,"c" , "d" , "e");
        System.out.println(r.record[1]);
        System.out.println(r);

        Record s = new Record("1", "2");
        System.out.println(s);

    }
}