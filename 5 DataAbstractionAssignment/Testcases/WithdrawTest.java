import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WithdrawTest {
    @Before
    public void setup(){
    }


    @Test // Test if the .ToString function display correctly for Saving account
    public void test_withdraw_ToString1(){
        // generate a test deposit record
        Date day= new Date(122, 10, 15, 5,30,12);
        // Date is initialized as:   Tue Nov 15 05:30:12 CST 2022
        double amount = 1000;
        String account = "Saving";

        // create a withdrawal item
        Withdraw Withdraw_item = new Withdraw(amount, day, account);

        // desired output
        String Actual_result;
        Actual_result = "Withdrawal of $" + "1000.0" + "\t" + "  Date:Tue Nov 15 05:30:12 CST 2022 from account: Saving";

        // compare to real output from the Withdraw.toString method
        assertEquals(Withdraw_item.toString().substring(0,48), Actual_result.substring(0,48));
        assertEquals(Withdraw_item.toString().substring(52,78), Actual_result.substring(52,78));
    }

    @Test // Test if the .ToString function display correctly for Checking account
    public void test_withdraw_ToString2(){
        // generate a test deposit record
        Date day= new Date(120, 1, 5, 2,30,12);
        // Date is initialized as:   Wed Feb 05 02:30:12 CST 2020
        double amount = 321;
        String account = "Checking";

        // create a withdrawal item
        Withdraw Withdraw_item = new Withdraw(amount, day, account);

        // desired output
        String Actual_result;
        Actual_result = "Withdrawal of $" + "321.0" + "\t" + "  Date:Wed Feb 05 02:30:12 CST 2020 from account: Checking";

        // compare to real output from the Withdraw.toString method
        assertEquals(Withdraw_item.toString().substring(0,48), Actual_result.substring(0,48));
        assertEquals(Withdraw_item.toString().substring(52,78), Actual_result.substring(52,78));
    }

}
