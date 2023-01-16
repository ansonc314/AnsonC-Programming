package com.example.safe;

        import org.junit.Before;
        import org.junit.Test;
        import java.io.IOException;
        import static org.junit.Assert.assertEquals;

public class test_Password {
    Password password;
    @Before
    public void setup() throws IOException {
    }

    @Test  // this test the password length check functino
    public void mytest_lengthcheck() throws IOException {
        Password password = new Password("");

        password.set_Password("1234567");
        boolean value = password.length_check();
        assertEquals(value,false);

        password.set_Password("12345678");
        value = password.length_check();
        assertEquals(value,true);


    }

    @Test  // this test the character_check function
    public void mytest_charactercheck() throws IOException {
        Password password = new Password("");
        boolean value;

        password.set_Password("abc");
        value = password.character_check();
        assertEquals(value,true);  // password with only lower case char

        password.set_Password("abcdef");
        value = password.character_check();
        assertEquals(value,true);  // password with only lower case char

        password.set_Password("aBcd");
        value = password.character_check();
        assertEquals(value,false);   // password invalid due to have a upper case char

        password.set_Password("abc3d");
        value = password.character_check();    // password invalid due to have a number
        assertEquals(value,false);

    }
}