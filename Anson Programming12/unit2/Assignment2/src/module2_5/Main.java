package module2_5;

public class Main {
    public static void main(String[] args){

        Cipher c = new Cipher(0);
        c.resetKey(2);   // reset the key to a different number
        System.out.println(c);

        String s = "a eel z";
        s= c.encryptString(s);
        System.out.println(s);

        String p= c.decryptString(s);
        System.out.println(p);


    }



}
