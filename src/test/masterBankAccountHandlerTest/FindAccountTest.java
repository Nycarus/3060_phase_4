package test.masterBankAccountHandlerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.masterbank.*;

public class FindAccountTest {
	/**
	 * FindAccountTest
	 * 
	 * Statement coverage for MasterBankAccountHandler.findAccount()
	 */
	
    @Test
    public void findAccountTest1() {
    	/**
    	 * findAccountTest1
    	 * 
    	 * Covers statements 1 through 3 (for loop, if statement, return account).
    	 * Determines if an existing account with matching name and account number can be found.
    	 */
    	
    	// Initialize the objects used in the test
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        ArrayList<MasterBankAccountData> accountsList = new ArrayList<MasterBankAccountData>();
        MasterBankAccountData testAccount = new MasterBankAccountData(0, "John", "", 0.0f, 0);
        accountsList.add(testAccount);
        masterBankAccountHandler.setAccounts(accountsList);

        // Test
        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertEquals("John", masterbankAccount.getName());
        assertEquals(0, masterbankAccount.getNumber());
    }

    @Test
    public void findAccountTest2(){
    	/**
    	 * findAccountTest2
    	 * 
    	 * Covers statements 1 and 4 (for loop, return null).
    	 * Runs findAccount on an empty account set (so that it can never find a match), and ensures null is correctly output.
    	 */
    	
        // Initialize the objects used in the test
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        ArrayList<MasterBankAccountData> accountsList = new ArrayList<MasterBankAccountData>();
        MasterBankAccountData testAccount = new MasterBankAccountData(0, "A", "", 0.0f, 0);
        accountsList.add(testAccount);
        masterBankAccountHandler.setAccounts(accountsList);

        // Test
        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertNull(masterbankAccount);
    }
}
