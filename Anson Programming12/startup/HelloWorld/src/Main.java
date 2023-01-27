
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 20;
        int y = 15;
        boolean z = false;
        System.out.println(!z || x < y);


        //question4();
    }



    public static void question4(){
        int arraySize=5;
        int numbers[] = new int[arraySize];
        int reverseNumbers[] = new int[arraySize];

        Random rand = new Random();   // obj to generate random number

        for (int i=0; i<arraySize ; i++ ){            // generate random array
            numbers[i] =     rand.nextInt(9);
        }
        System.out.println("The random array is ");    // print array
        System.out.println(Arrays.toString(numbers));

        for (int i=0; i<arraySize ; i++ ){             // reverse the array
            reverseNumbers[arraySize-1-i] = numbers[i];
        }

        System.out.println("The reverse random array is ");  // print reversed array
        System.out.println(Arrays.toString(reverseNumbers));
    }
    public static void question3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many hotdogs do you want?");
        int hotdogs = scanner.nextInt();
        System.out.println("How many drinks do you want?");
        int drinks = scanner.nextInt();

        double total = (hotdogs*3.5 + drinks)*1.12;
        total = Math.round(total * 100.0) / 100.0;
        System.out.println("Total you owe " + total);
    }
}

/*
Codes for circle class
        Circle c = new Circle(2);
        double tmp ;
        tmp = c.getRadius();
        System.out.println(tmp);
        System.out.println(c);

        c.setRadius(10);
        System.out.println(tmp);
        System.out.println(c);

        tmp = c.getArea();
        System.out.println(tmp);
        System.out.println(c);

        tmp = c.getCircumference();
        System.out.println(tmp);
        System.out.println(c);


 */
