package test.masterBankAccountHandlerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.masterbank.*;

public class FindAccountTest {
    @Test
    public void findAccountTest1() {
    	// Initialize the objects used in the test
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        ArrayList<MasterBankAccountData> accountsList = new ArrayList<MasterBankAccountData>();
        MasterBankAccountData testAccount = new MasterBankAccountData(0, "John", "", 0.0f, 0, false);
        accountsList.add(testAccount);
        masterBankAccountHandler.setAccounts(accountsList);

        // Test
        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertEquals("John", masterbankAccount.getName());
        assertEquals(0, masterbankAccount.getNumber());
    }

    @Test
    public void findAccountTest2(){
        // Initialize the objects used in the test
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        ArrayList<MasterBankAccountData> accountsList = new ArrayList<MasterBankAccountData>();
        MasterBankAccountData testAccount = new MasterBankAccountData(0, "A", "", 0.0f, 0, false);
        accountsList.add(testAccount);
        masterBankAccountHandler.setAccounts(accountsList);

        // Test
        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertNull(masterbankAccount);
    }
}
