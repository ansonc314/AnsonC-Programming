package com.example.safe;

import org.junit.Before;
import org.junit.Test;
import java.lang.*;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class test_mixing {


    Password password;
    @Before
    public void setup() throws IOException {
    }

    @Test  // this test check the mix method.
    public void test_method_mix() {
        mixing rand = new mixing("ab");
        assertEquals(rand.get_passwd_int(), 97+98);  // check if passwd_int is generated correctly

        String str = "ry";
        int tmp = rand.get_passwd_int();
        int newvalue =  (int) str.charAt(0) + 1 + ((tmp + 0*0)%15);
        assertEquals((int) rand.mix(str).charAt(0), newvalue);        // check if the first char is encrypted properly

        newvalue =  (int) str.charAt(1) + 1 + ((tmp + 1*1)%15);
        assertEquals((int) rand.mix(str).charAt(1), newvalue);   // check if the second char is encrypted properly

    }

    @Test  // this test check the unmix method.
    public void test_method_unmix() {
        mixing rand = new mixing("ab");
        assertEquals(rand.get_passwd_int(), 97+98);  // check if passwd_int is generated correctly

        String str = "ry";

        int tmp = rand.get_passwd_int();
        int newvalue =  (int) str.charAt(0) - 1 - ((tmp + 0*0)%15);   // check if the first char is encrypted properly
        assertEquals((int) rand.unmix(str).charAt(0), newvalue);

        newvalue =  (int) str.charAt(1) - 1 - ((tmp + 1*1)%15);  // check if the second char is encrypted properly
        assertEquals((int) rand.unmix(str).charAt(1), newvalue);


    }


    @Test // this test check if mix and unmix reverse each other.
    public void test_method_mix_unmix() {
        mixing rand = new mixing("ab");

        String str = "test";
        assertEquals(rand.unmix(rand.mix(str))   , str);
        assertEquals(rand.mix(rand.unmix(str))   , str);

    }


}