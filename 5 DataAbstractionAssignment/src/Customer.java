import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;     // Bank account number
    private ArrayList<Deposit> deposits;   // list of deposit records
    private ArrayList<Withdraw> withdraws;  // list of withdraw records
    private double checkBalance;  //  checking account balance
    private double savingBalance;  // saving account balance
    private double savingRate;  // saving interest rate
    private String name;   // customer name
    public static final String CHECKING = "Checking";   // checking account name
    public static final String SAVING = "Saving";   // saving account name
    private final int OVERDRAFT = -100;   //  maximum overdraft amount

    // Default constructor
    Customer(){
        //create default constructor
        this.name = "Default";
        this.checkBalance = 0;
        this.savingBalance = 0;
        this.withdraws = new ArrayList<>();
        this.deposits = new ArrayList<>();
    }

    // Constructor
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.checkBalance = checkDeposit;   // initial deposit to checking account
        this.savingBalance = savingDeposit; // initial deposit to saving account
        this.withdraws = new ArrayList<>();
        this.deposits = new ArrayList<>();

    }

    public double deposit(double amt, Date date, String account){
        // Requires: amt>0, account  = "Checking" or "Saving"
        // Modifies: this, checkBalance or savingBalance, deposits or withdraws
        // Effects: adds amt to checkBalance / savingBalance and the function output is value equal to the new account balance.
        //           If there is any error, the output is an error code of -1000

        // step 1: check if amt > 0
        if (amt <= 0) {
            // print error message
            System.out.println("Amount value not valid. Deposit transaction aborted.");
            return  -1000 ;  //  error code
        }
        // step 2:  check if the account name is correct
        if (account != CHECKING && account != SAVING) {
            // print error message
            System.out.println("Account not valid. Deposit transaction aborted.");
            return -1000 ;  // error code
            // do nothing
        }
        // step 3: create a deposit object
        Deposit newDeposit  = new Deposit(amt, date, account);
        // step 4: add to deposit list
        deposits.add(newDeposit);

        // step 4: update account balance
        if (account == SAVING){
            this.savingBalance = this.savingBalance +  amt;
            System.out.println(newDeposit);   // print deposit record
            this.display_saving_balance();    // print current balance
            return this.savingBalance;
        }
        if (account == CHECKING){
            this.checkBalance = this.checkBalance +  amt;
            System.out.println(newDeposit);  // print deposit record
            this.display_checking_balance(); // print current balance
            return this.checkBalance;
        }

    return -1000;   // return error code

    }

    public double withdraw(double amt, Date date, String account){
        // Requires: amt>0, account  = "Checking" or "Saving", amt < balance
        // Modifies: this, checkBalance or savingBalance, deposits or withdraws
        // Effects: Withdraw amt from checkBalance / savingBalance and the function output
        //          is value equal to the new account balance.
        //          If there is any error, the output is an error code of -1000


        // step 1: check if amt > 0
        if (amt <= 0) {
            System.out.println("Amount value not valid. Withdrawal transaction aborted.");
            return -1000;
        }

        // step 2: check if the account name is correct
        if (account != CHECKING && account != SAVING) {
        // print error message
        System.out.println("Account not valid. Withdrawal transaction aborted.");
        return -1000;
        }

        // step 3: check if there is overdraft
        if (checkOverdraft(amt,account)) {
            // print error message
            System.out.println("Withdrawal aborted: Insufficient balance in your " + account + " account.");
            return -1000;
        }


        // step 4: create a withdraw object
        Withdraw newWithdraw  = new Withdraw(amt, date, account);

        // step 5: add to withdraws list
        withdraws.add(newWithdraw);

        // step 6: update account balance
        if (account == SAVING){
            this.savingBalance = this.savingBalance -  amt;
            System.out.println(newWithdraw); // print out withdrawal transaction
            this.display_saving_balance(); // print out current balance
            return this.savingBalance;
        }
        if (account == CHECKING){
            this.checkBalance = this.checkBalance   - amt;
            System.out.println(newWithdraw); // print out withdrawal transaction
            this.display_checking_balance(); // print out current balance
        return this.checkBalance;
        }
    return -1000;
    }


    private boolean checkOverdraft(double amt, String account){
    // Requires : double amt <= account balance + 100 , String account
    // Effects: Return true if withdraw amt > account balance + 100

        boolean result = true;
        if (account == CHECKING){
            if (this.checkBalance  -  amt >= OVERDRAFT) {result =  false;}  // if overdraft limit exceeds, set result = true
            else {result = true;}
        }
        if (account == SAVING){
            if (this.savingBalance  -  amt >= OVERDRAFT) {result =  false;}  // if overdraft limit exceeds, set result = true
            else {result = true;}
        }

        return result;
    }


// Implementation of Getters  ****************************************
    public double get_checking_balance(){
    // Effect: return check account balance
        return this.checkBalance;
    }


    public double get_saving_balance(){
    // Effect: return saving account balance
        return this.savingBalance;
    }


    public void display_checking_balance(){
    // Effects:  print out checking account balance
        System.out.println("Current Balance in CHECKING account is " +  this.checkBalance);
        return;
    }

    public void display_saving_balance(){
        // Effects:  print out saving account balance
        System.out.println("Current Balance in SAVING account is " +  this.savingBalance);
        return;
    }


    //  Methods to display transaction records
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
