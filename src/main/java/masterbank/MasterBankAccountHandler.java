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
 *  This class is intended to handle MasterBankAccountData methods
 *  readFile() - > reads current master bank accounts
 *  writeFile() - >  updates current master bank accounts
 *  getAccounts() - > returns the list of accounts
 *
 */
public class MasterBankAccountHandler {
    private List<MasterBankAccountData> accounts = new ArrayList<>();

    public MasterBankAccountHandler(){}

	/**
	 * getAccounts
	 *
	 * returns a list of accounts
	 *
	 * @return accounts<MasterBankAccountData>
	 */
	public List<MasterBankAccountData> getAccounts() {
        return this.accounts;
    }

	/**
	 * setAccounts
	 *
	 * Set the accounts list equal to a target object
	 *
	 * @param target The new list to use for the handler's account data.
	 */
	public void setAccounts(List<MasterBankAccountData> target) {
    	this.accounts = target;
	}
	/**
	 * findAccount
	 *
	 * find an account based on the number and the name given
	 *
	 * @return account the account that was found with the name and number
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
	 * Reads in MasterBankAccount files and stores them in a list to process transactions on
	 *
	 * @param file the name of the file to be processed
	 */
	public String readFile(String file) {
		File inMaster = new File(file);
		//Testing
		String testReturn = "";
    	  if(!inMaster.exists()){
    		  	System.out.println("ERROR: Master bank account file does not exist");
				return("ERROR: Master bank account file does not exist");
			  }else{
				try{
					Scanner reader = new Scanner(inMaster);
					//Read each bank account file
	
					while(reader.hasNextLine()){
					String account = reader.nextLine();
					testReturn = testReturn.concat(account);
    				//Parse account string

    				MasterBankAccountData temp =
    				new MasterBankAccountData(Integer.parseInt(account.substring(0, 5)), account.substring(6,27), account.substring(27,28), Float.parseFloat(account.substring(29,37)), Integer.parseInt(account.substring(38,42)));
    				//Testing Purposes
    				System.out.println(testReturn);
    				accounts.add(temp);
    				
    	    		
					}
				
    	reader.close();
    	}catch(Exception e){
    		//If Account it wrong type or Error with file
    		System.out.println("ERROR: Master bank account file cannot be opened");
    		e.printStackTrace();
    		return("ERROR: Master bank account file cannot be opened");
    		}		
    	return(testReturn);
		}
    }

    //Writing to new current and master account files

	/**
	 * writeFile
	 *
	 * Creates/Updates a new updated masterbankaccount file which has all the transactions processed
	 *
	 * @param file the name of the file to be written to
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
    	      System.out.println("ERROR: Master bank account file cannot be written to");
    	      e.printStackTrace();
    	    }

			
    }
}
