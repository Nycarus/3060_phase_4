package main.java.masterbank;
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class MasterBankAccountHandler {
    private List<MasterBankAccountData> accounts;

    MasterBankAccountHandler(){
        
    }

    public List<MasterBankAccountData> getAccounts() {
        return this.accounts;
    }

    // Might not be needed
    public MasterBankAccountData findAccount() {
        return null;
    }

    public void readFile(String file) {
    	try{
    		File inMaster = new File(file);
    		Scanner reader = new Scanner(inMaster);
    		//Read each bank account file 
    		String account = reader.nextLine();
    		//Process file accounts
    		
    		//Parse Strings method
    		
    		//Testing purposes
    		System.out.println(account);
    		reader.close();
    	}catch(FileNotFoundException e){
    		//If Account it wrong type or Error with file
    		System.out.println("Master bank account file cannot be opened!");
    		e.printStackTrace();
    	}	
    }

    public void writeFile(String file) {
    	try {
    	      FileWriter writer = new FileWriter(file);
    	      //Write updated bank account files 
    	      writer.write("0000000000000000000000");
    	      writer.close();
    	      System.out.println("Wrote to Master Bank account file");
    	      
    	      //File cannot be opened to write
    	    }catch (IOException e) {
    	      System.out.println("Error occured with Masterbank Account File");
    	      e.printStackTrace();
    	    }
    }
}