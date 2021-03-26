package main.java.masterbank;
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//Reading old banking account and writing new master accounts

/**
 * MasterBankAccountHandler
 *
 * TODO: [DESCRIPTION HERE!!!]
 */
public class MasterBankAccountHandler {
    private List<MasterBankAccountData> accounts = new ArrayList<>();

    public MasterBankAccountHandler(){}

	/**
	 * getAccounts
	 *
	 * TODO: [DESCRIPTION HERE!!!]
	 *
	 * @return TODO: [DESCRIPTION HERE!!!]
	 */
	public List<MasterBankAccountData> getAccounts() {
        return this.accounts;
    }

	/**
	 * setAccounts
	 *
	 * TODO: [DESCRIPTION HERE!!!]
	 *
	 * @param target TODO: [DESCRIPTION HERE!!!]
	 */
	public void setAccounts(List<MasterBankAccountData> target) {
    	this.accounts = target;
	}

    // Might not be needed
	/**
	 * findAccount
	 *
	 * TODO: [DESCRIPTION HERE!!!]
	 *
	 * @return TODO: [DESCRIPTION HERE!!!]
	 */
    public MasterBankAccountData findAccount(String name, int number) {
        for (MasterBankAccountData account : this.accounts) {
			if (account.name == name && account.number == number) {
				return account;
			}
		}

		return null;
    }

	/**
	 * exists
	 *
	 * A simple check to see if the account ID is present already in accounts, used to enforce the duplicate ID constraint
	 *
	 * @param accountID the ID number to check
	 * @return true if an account with the same ID number is present in the Handler's list of accounts
	 */
	public boolean exists(int accountID) {
    	for (MasterBankAccountData account : this.accounts) {
    		if (accountID == account.number) {
    			return true;
			}
		}

    	//for loop exhausted, therefore ID not found
    	return false;
	}
    
    //Reading in banking old master and merge bank accounts
    //Sample account format 12345 John Doe             A 00000000 0001 1

	/**
	 * readFile
	 *
	 * TODO: [DESCRIPTION HERE!!!]
	 *
	 * @param file TODO: [DESCRIPTION HERE!!!]
	 */
	public void readFile(String file) {
    	try{
    		File inMaster = new File(file);
    		Scanner reader = new Scanner(inMaster);
    		//Read each bank account file 
    		while(reader.hasNextLine()){
    			String account = reader.nextLine();
        		//Parse account string
        		
        		
        		MasterBankAccountData temp = 
        				new MasterBankAccountData(Integer.parseInt(account.substring(0, 5)), account.substring(6,27), account.substring(27,28), Float.parseFloat(account.substring(29,36)), Integer.parseInt(account.substring(38,42)), Boolean.parseBoolean(account.substring(43,47)));
        		//Testing Purposes       		
        		System.out.println(temp);
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

	/**
	 * writeFile
	 *
	 * TODO: [DESCRIPTION HERE!!!]
	 *
	 * @param file TODO: [DESCRIPTION HERE!!!]
	 * @param isMaster Flags whether or not the file to be output is a master bank account. If not,
	 *                 it's a current bank account file, and the transaction count shouldn't be recorded.
	 */
    public void writeFile(String file, boolean isMaster) {
    	try {
    	      FileWriter writer = new FileWriter(file);
    	      //Write updated bank account files
    	      for(int i = 0; i < accounts.size(); i++){
    	    	  writer.write(accounts.get(i).toString(isMaster)+ "\n");
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






