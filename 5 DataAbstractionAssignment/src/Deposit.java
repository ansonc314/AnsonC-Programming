import java.util.Date;

public class Deposit {
    private double amount;  // deposit amount
    private Date date;      // deposit date
    private String account; // deposit account name


    // Constructor
    // Requires: double, amount;  Date, date; and String, account
    // Modifies: this
    // Effects: assign amount, date, account to the corresponding field values
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    // Effects: Return the Deposit transaction record as a String
    public String toString(){
        String result;
             result = "Deposit of $" + amount + "\t" + "  Date: " + date + " into account: " + account;
         return result;
    }
}
