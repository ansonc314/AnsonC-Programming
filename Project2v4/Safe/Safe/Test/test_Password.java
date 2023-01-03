package com.example.safe;

        import org.junit.Before;
        import org.junit.Test;
        import java.lang.*;
        import java.io.IOException;

        import static org.junit.Assert.assertEquals;

public class test_Password {
    Password password;
    @Before
    public void setup() throws IOException {
    }

    @Test
    public void mytest() throws IOException {
        Password password = new Password("");

        password.set_Password("1234567");
        boolean value = password.length_check();
        assertEquals(value,false);

        password.set_Password("12345678");
        value = password.length_check();
        assertEquals(value,true);

        password.set_Password("abc");
        value = password.character_check();
        assertEquals(value,true);

        password.set_Password("ABC");
        value = password.character_check();
        assertEquals(value,false);

        password.set_Password("123");
        value = password.character_check();
        assertEquals(value,false);

    }
}