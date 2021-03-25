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

    MasterBankAccountHandler(){
        
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
        		String[] holder = account.split(" ");
        		//Testing Purposes
        		System.out.println(account);
        		for(String i : holder){
        			System.out.println(i);
        		}
        		
        		MasterBankAccountData temp 
        		= new MasterBankAccountData(Integer.parseInt(holder[0]), holder[1], holder[2], Float.parseFloat(holder[3]), Integer.parseInt(holder[4]), Boolean.parseBoolean(holder[5]));
        		accounts.add(temp);
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
    	      for(int i = 0; i < accounts.size(); i++){
    	    	  writer.write(accounts.get(i).toString());
    	      }
    	      writer.close();
    	      System.out.println("Wrote to Master Bank account file");
    	      //File cannot be opened to write
    	    }catch (IOException e) {
    	      System.out.println("Error occured with Masterbank Account File");
    	      e.printStackTrace();
    	    }
    }
}






