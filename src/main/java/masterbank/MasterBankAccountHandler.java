package main.java.masterbank;
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

//Reading old banking account and writing new master accounts
public class MasterBankAccountHandler {
    private List<MasterBankAccountData> accounts;

    public MasterBankAccountHandler(){
        
    }

    public List<MasterBankAccountData> getAccounts() {
        return this.accounts;
    }

    // Might not be needed
    public MasterBankAccountData findAccount() {
        return null;
    }
    
    //Reading in banking old master and merge bank accounts
    
    //Sample account format 12345 John Doe             A 00000000 0001 1
    public void readFile(String file) {
    	try{
    		File inMaster = new File(file);
    		Scanner reader = new Scanner(inMaster);
    		//Read each bank account file 
    		while(reader.hasNextLine()){
    			String account = reader.nextLine();
        		//Parse account string
        		
        		
        		MasterBankAccountData temp = 
        				new MasterBankAccountData(Integer.parseInt(account.substring(0, 5)), account.substring(6,27), account.substring(27,28), Float.parseFloat(account.substring(29,36)), Integer.parseInt(account.substring(38,42)), Boolean.parseBoolean(account.substring(43,44)));
        		//Testing Purposes       		
        		System.out.println(temp);
        		//accounts.add(temp);
    		}
    		//Process file accounts
    	
    		reader.close();
    	}catch(FileNotFoundException e){
    		//If Account it wrong type or Error with file
    		System.out.println("Master bank account file cannot be opened!");
    		e.printStackTrace();
    	}	
    }
    
    //Writing to new current and master account files
    public void writeFile(String file) {
    	try {
    	      FileWriter writer = new FileWriter(file);
    	      //Write updated bank account files
    	      //for(int i = 0; i < accounts.size(); i++){
    	    	  //writer.write(accounts.get(i).toString());
    	      //}
    	      writer.close();
    	      System.out.println("Wrote to Master Bank account file");
    	      //File cannot be opened to write
    	    }catch (IOException e) {
    	      System.out.println("Error occured with Masterbank Account File");
    	      e.printStackTrace();
    	    }
    }
}






