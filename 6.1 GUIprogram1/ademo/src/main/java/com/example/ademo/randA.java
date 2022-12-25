package com.example.ademo;

import java.util.Random;

public class randA {
// Effects: This class provides methods to generate random integers

   public int newNo(){
   // Effects: return a number between 1 and 10.
        Random rand = new Random() ;
        return rand.nextInt(1, 10);
    }
    public int computerNo(){
    // Effects: return a number between 16 and 21.
        Random rand = new Random() ;
        return rand.nextInt(16, 21);
        // this subroutine is for the computer to generate a number between 16 and 21.
    }

}
