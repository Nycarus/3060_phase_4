package test.masterBankAccountHandlerTest;

import static org.junit.Assert.*;
import main.java.masterbank.*;

public class FindAccountTest {

    @Test
    public void findAccountTest1() {
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        masterBankAccountHandler.readFile(masterBankAccountInputFile);

        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertEquals("John", masterbankAccount.name);
        assertEquals(0, masterbankAccount.number);
    }

    @Test
    public void findAccountTest2(){
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        masterBankAccountHandler.readFile(masterBankAccountInputFile);

        MasterBankAccountData masterbankAccount = masterBankAccountHandler.findAccount("John",0);
        assertNull(masterbankAccount);
    }
}
