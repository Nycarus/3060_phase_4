package test.masterBankAccountHandlerTest;

import static org.junit.Assert.*;

public class FindAccountTest {
	
    @Test
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

	

	
	


    }
}
