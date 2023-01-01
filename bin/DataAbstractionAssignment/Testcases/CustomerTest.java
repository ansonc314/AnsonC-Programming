import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {
    Customer testCustomer;
    Date d1;

    @Before
    public void setup(){
        // Create a test customer,
        testCustomer = new Customer("Tom", 12345,1024, 512);
          d1 = new Date(122, 10, 15, 5, 30, 12);
        // Date is initialized as:   Tue Nov 15 05:30:12 CST 2022
    }


    @Test  //Test 1:  Verify one cannot deposit negative amount
    public void test_customer_deposit1() {

        System.out.println("Test 1: Verify one cannot deposit / withdraw negative amount, and the account name must be correct");
        assertEquals(testCustomer.deposit(-10000, d1, "Saving"), -1000, 0.1);
        assertEquals(testCustomer.deposit(-10980, d1, "Checking"), -1000, 0.1);
        // an error code - 1000 will be returned

        assertEquals(testCustomer.withdraw(-10000, d1, "Saving"), -1000, 0.1);
        assertEquals(testCustomer.withdraw(-10980, d1, "Checking"), -1000, 0.1);


        assertEquals(testCustomer.deposit(10000, d1, "Safing"), -1000, 0.1);
        assertEquals(testCustomer.deposit(10980, d1, "Chck"), -1000, 0.1);
        testCustomer.displayDeposits();
        // an error code - 1000 will be returned

        assertEquals(testCustomer.withdraw(40000, d1, "aving"), -1000, 0.1);
        assertEquals(testCustomer.withdraw( 40980, d1, "Cecking"), -1000, 0.1);
        testCustomer.displayWithdraws();


    }

    @Test  //Test 2:   deposit to checking account
    public void test_customer_deposit2(){
        System.out.println("Test 2: Deposit to checking");

        double before_deposit = testCustomer.get_checking_balance();
        testCustomer.display_checking_balance();
        testCustomer.deposit(200,d1, "Checking"); // deposit $200 into checking account
        double after_deposit = testCustomer.get_checking_balance();
        assertEquals(before_deposit+200, after_deposit, 0.001); // check if the balance is updated correctly or not

    }

    @Test  //Test 3:  deposit to saving account
    public void test_customer_deposit3(){
        System.out.println("Test 3: Deposit to saving");

        double before_deposit = testCustomer.get_saving_balance();
        testCustomer.display_saving_balance();
        testCustomer.deposit(20,d1, "Saving"); // deposit $20 into saving account
        double after_deposit = testCustomer.get_saving_balance();
        assertEquals(before_deposit+20, after_deposit, 0.001); // check if the balance is updated correctly or not

    }

    @Test  //Test 4:   withdraw from checking account
    public void test_customer_deposit4(){
        System.out.println("Test 4: Withdraw from checking");

        double before_withdraw = testCustomer.get_checking_balance();
        testCustomer.display_checking_balance();
        testCustomer.withdraw(200,d1, "Checking"); // withdraw $200 from checking account
        double after_withdraw = testCustomer.get_checking_balance();
        assertEquals(before_withdraw - 200, after_withdraw, 0.001); // check if the balance is updated correctly or not

    }

    @Test  //Test 5:   Withdraw from saving
    public void test_customer_deposit5(){
        System.out.println("Test 5: Withdraw from saving");

        double before_withdraw = testCustomer.get_saving_balance();
        testCustomer.display_saving_balance();
        testCustomer.withdraw(100,d1, "Saving"); // withdraw $200 from saving account
        double after_withdraw = testCustomer.get_saving_balance();
        assertEquals(before_withdraw - 100, after_withdraw, 0.001); // check if the balance is updated correctly or not

    }


    @Test  //Test 6:  Check overdraft
    public void test_customer_deposit6() {
        System.out.println("Test 6: Check overdraft test is met");

        // overdraft test for checking account
        double before_withdraw = testCustomer.get_checking_balance();
        testCustomer.display_checking_balance();
        double after_withdraw = testCustomer.withdraw(123456,d1, "Checking"); // withdraw $123456 from checking account
        assertEquals(after_withdraw,-1000,0.001);// check if the overdraft error is caught
        testCustomer.display_checking_balance();
        assertEquals(testCustomer.get_checking_balance(), before_withdraw, 0.001  );  // check balance unchanged

        after_withdraw = testCustomer.withdraw(before_withdraw+100,d1, "Checking"); // withdraw $1124 from checking account
        assertEquals(after_withdraw,-100,0.001);// check if the balance is updated correctly or not

        System.out.println("\n");

        //overdraft test for saving account
        before_withdraw = testCustomer.get_saving_balance();
        testCustomer.display_saving_balance();
        after_withdraw = testCustomer.withdraw(123456,d1, "Saving"); // withdraw $123456 from checking account
        assertEquals(after_withdraw,-1000,0.0);// check if the balance is updated correctly or not
        testCustomer.display_saving_balance();
        assertEquals(testCustomer.get_saving_balance(), before_withdraw, 0.001  );  // check balance unchanged

        after_withdraw = testCustomer.withdraw(before_withdraw+100,d1, "Saving"); // withdraw $612 from saving account
        assertEquals(after_withdraw,-100,0.001);// check if the balance is updated correctly or not

    }



}
