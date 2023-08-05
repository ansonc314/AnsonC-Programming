package module2_5;

public class Main {
    public static void main(String[] args){

        Cipher cc = new Cipher(1);
        cc.resetKey(22);   // reset the key to 2;
        String s = "eel";
        s= cc.encryptString(s);
        System.out.println(s);

        String p= cc.decryptString(s);
        System.out.println(p);


    }



}
