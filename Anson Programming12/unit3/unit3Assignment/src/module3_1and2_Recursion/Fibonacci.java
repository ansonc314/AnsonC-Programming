package module3_1and2_Recursion;

public class Fibonacci {

    /**
     * F(0) = 0; F(1) =1;  Fn = F(n-1) + F(n-2)
     * @param n
     * @return the n-th Fibonnaci number
     */
    static int FindFibonnaciNumber(int n)
    {
        if (n == 0) {  // base case when n = 0
            return 0;
        }
        if (n == 1) {  // base case when n = 1
            return 1;
        }
        return FindFibonnaciNumber(n-1) + FindFibonnaciNumber(n-2);
    }




}
