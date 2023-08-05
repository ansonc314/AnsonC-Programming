package module2_5;

import org.junit.Test;

import static org.junit.Assert.*;

public class CipherTest {

    @Test
    public void encryptString() {
        Cipher cc = new Cipher(3);
        String s = "abc xyz def";
        s= cc.encryptString(s);
        assertTrue(s.equals("def abc ghi"));
    }

    @Test
    public void decryptString() {
        Cipher cc = new Cipher(3);
        String s = "defabc ghi";
        s= cc.decryptString(s);
        assertTrue(s.equals("abcxyz def"));

    }
}