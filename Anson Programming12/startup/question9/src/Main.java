import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter x-coordinates");
        int x = scanner.nextInt();

        System.out.println("Enter y-coordinates");
        int y = scanner.nextInt();

        if (x>0 && y>0){
            System.out.println("The point is on the first quadrant");
        }

        if (x<0 && y>0){
            System.out.println("The point is on the second quadrant");
        }

        if (x<0 && y<0){
            System.out.println("The point is on the third quadrant");
        }

        if (x>0 && y<0){
            System.out.println("The point is on the fourth quadrant");
        }

        if (x==0 && y!=0){
            System.out.println("The point is on the y-axis");
        }


        if (y==0 && x!=0){
            System.out.println("The point is on the x-axis");
        }

        if (y==0 && x==0){
            System.out.println("The point is the origin");
        }


    }
}