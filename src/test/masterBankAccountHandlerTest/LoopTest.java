package test.masterBankAccountHandlerTest;
import static org.junit.Assert.*;
import main.java.masterbank.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class LoopTest {
    //verify results of first if check. Compares output when File does not exist
     @Test
	 public void testCondition() {
    	 MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
    	 assertEquals("ERROR: Master bank account file does not exist", masterBankAccountHandler.readFile("wrongfile.txt"));
     }
    //verify results of first if check. Compares output when File does exist
    @Test
    public void testLoop() throws IOException {
    	 MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        //Checks condition of an empty file
        assertEquals("", masterBankAccountHandler.readFile("test_Empty_file.txt"));
        //Checks condition of a file with one line 
        
	assertEquals("00001 John Doe             A 00000100 0001 true", masterBankAccountHandler.readFile("src/test/resources/looptest1.txt"));
        //cond twice
        assertEquals("00001 John Doe             A 00000100 0001 true 00002 John Dae             A 00000300 0002 false ",masterBankAccountHandler.readFile("src/test/resources/looptest2.txt"));
    }
   }
