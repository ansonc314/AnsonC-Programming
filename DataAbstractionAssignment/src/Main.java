import java.util.Date;
import java.util.Calendar;

public class Main {
    public static void main (String[] args) {

        Customer Tom = new Customer("Tom", 12345,1000, 20000);


        // new deposit
        Date d1= new Date(122, 10, 15, 5,30,12);
        //Date d1=  rightNow.getTime();

        Tom.deposit(100,d1, "Saving");
        Tom.deposit(200,d1, "Checking");
        Tom.deposit(300,d1, "Checking");
        Tom.deposit(400,d1, "Saving");

        // Tom.displayDeposits();
        Tom.withdraw(250.58,d1, "Saving");
        Tom.withdraw(100,d1, "Checking");
        Tom.withdraw(10000,d1, "Checking");


        System.out.println("\nPrinting deposit records");
        Tom.displayDeposits();

        System.out.println("\nPrinting withdrawal records");
        Tom.displayWithdraws();

        }
}
