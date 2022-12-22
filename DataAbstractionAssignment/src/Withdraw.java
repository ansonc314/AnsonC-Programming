import java.util.Date;

public class Withdraw {
    private double amount;   // Withdraw amount
    private Date date;   // Withdraw date
    private String account;    // Withdraw account


    // Constructor
    // Requires: double, amount;  Date, date; and String, account
    // Modifies: this
    // Effects: assign amount, date, account to the corresponding field values
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }



    // Effects: Return the withdrawal transaction record as a String
    public String toString(){
        String result;
        result = "Withdrawal of $" + amount + "\t" + "  Date:" + date + " from account: " + account;
        return result;
    }
}
