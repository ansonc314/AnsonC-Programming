package module2_5;

public class Main {
    public static void main(String[] args){


        String s = "abc def . yz";
        String o = Cipher.encrypt(2,s);
        System.out.println(o);
        System.out.println(Cipher.decrypt(2,o));


    }



}
