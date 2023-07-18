package module3_1and2_Recursion;

import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Scanner myInput = new Scanner( System.in );
        System.out.print( "Input : n =  " );
        int n = myInput.nextInt();

        System.out.print( "Output : " );
        System.out.println(Fibonacci.FindFibonnaciNumber(n));

    }

}
