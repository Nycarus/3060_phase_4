package test.masterBankAccountHandlerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.java.masterbank.*;

public class FindAccountTest {

    @Test
    public void findAccountTest1() {
    	//Initialize the objects used in the test
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        ArrayList<MasterBankAccountData> accountsList = new ArrayList<MasterBankAccountData>();
        MasterBankAccountData testAccount = new MasterBankAccountData(0, "John", "", 0.0f, 0, false);
        accountsList.add(testAccount);
        masterBankAccountHandler.setAccounts(accountsList);

        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertEquals("John", masterbankAccount.name);
        assertEquals(0, masterbankAccount.number);
    }

    @Test
    public void findAccountTest2(){
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        masterBankAccountHandler.readFile("src/test/resources/master_bank_accounts.txt");

        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertNull(masterbankAccount);
    }
}
