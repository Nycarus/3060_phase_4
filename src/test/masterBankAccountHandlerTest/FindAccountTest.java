package test.masterBankAccountHandlerTest;

import static org.junit.Assert.*;
import main.java.masterbank.*;

public class FindAccountTest {
	
    @Test
<<<<<<< HEAD
    public void testChangeBalance() {
        Junit test = new Junit();

    }
	//verify results of first if check. Compares output when File does not exist
	 @Test
    public void testReadFile() {
         @Test
		public void testSetImageForConditionOne() {
		 Assert.assertEquals("ERROR: Master bank account file does not exist", readFile("wrongfile.txt"));
     
    }
	//verify results of first if check. Compares output when File does exist
    @Test
    public void testSetImageForElseCondition() {

		//Checks condition of an empty file
        File test = new file("test_Empty_file.txt");
		test.createNewFile();
         Assert.assertEquals("", readFile("test_Empty_file.txt"));


		//Checks condition of a file with one line
		 File test = new file("test_one_iteration_file.txt");
		 test.createNewFile();
		 FileWriter myWriter = new FileWriter(file);
		 myWriter.write("00001 John Doe             A 00000100 0001 true");
         Assert.assertEquals("00001 John Doe             A 00000100 0001 true",file );

		 // cond twice
		  File test = new file("test_one_iteration_file.txt");
		 test.createNewFile();
		 FileWriter myWriter = new FileWriter(file);
		 myWriter.write("00001 John Doe             A 00000100 0001 true");
		 myWriter.write("00002 John Dae             A 00000300 0002 false");
         Assert.assertEquals("00001 John Doe             A 00000100 0001 true\n00002 John Dae             A 00000300 0002 false ",file);


	}

	

	
	


=======
    public void findAccountTest1() {
        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        masterBankAccountHandler.readFile("src/test/resources/master_bank_accounts.txt");

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
>>>>>>> 35a0aea360876160a5712e1def2c68df0d945010
    }
}
