package test.masterBankAccountHandlerTest;

import static org.junit.Assert.*;
import main.java.masterbank.*;

public class FindAccountTest {

    @Test
    public void findAccountTest1() {
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        masterBankAccountHandler.readFile("src/test/resources/master_bank_accounts.txt");

        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertEquals("John", masterbankAccount.getName());
        assertEquals(0, masterbankAccount.getNumber());
    }

    @Test
    public void findAccountTest2(){
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        masterBankAccountHandler.readFile("src/test/resources/master_bank_accounts.txt");

        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertNull(masterbankAccount);
    }
}
