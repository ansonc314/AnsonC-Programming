import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DepositTest {
    @Before
    public void setup(){
    }


    @Test // Test if the .ToString function display correctly for Saving account
    public void test_deposit_ToString1(){
        // generate a test deposit record
        Date day= new Date(122, 10, 15, 5,30,12);
        // Date is initialized as:   Tue Nov 15 05:30:12 CST 2022
        double amount = 1000;
        String account = "Saving";

        // create a deposit item
        Deposit Deposit_item = new Deposit(amount, day, account);

        // desired output
        String result;
        result = "Deposit of $" + "1000.0" + "\t" + "  Date: Tue Nov 15 05:30:12 CST 2022 into account: Saving";

        // compare to real output from the deposit.toString method
        assertEquals(Deposit_item.toString(), result);
    }

    @Test  // Test if the .ToString function display correctly for Saving account
    public void test_deposit_ToString2(){

        // generate a test deposit record to the Checking account
        Date day= new Date(112, 0, 2, 5,30,12);
        // Date is initialized as:   Mon Jan 02 05:30:12 CST 2012
        double amount = 140;
        String account = "Checking";

        // create a deposit item
        Deposit Deposit_item = new Deposit(amount, day, account);

        // desired output
        String result;
        result = "Deposit of $" + "140.0" + "\t" + "  Date: Mon Jan 02 05:30:12 CST 2012 into account: Checking";

        // compare to real output from the deposit.toString method
        assertEquals(Deposit_item.toString(), result);
    }
}
