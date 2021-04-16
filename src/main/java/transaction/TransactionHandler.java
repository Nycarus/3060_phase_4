package main.java.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import java.io.BufferedReader;
import java.io.File;

/**
 * TransactionHandler
 *
 * Responsible for handling reading, converting, and storing transaction files into more easily-accessible
 * TransactionData instances.
 */
public class TransactionHandler {
    private List<TransactionData> transactions;

    /**
     * TransactionHandler
     *
     * 0-parameter version of TransactionHandler's initializer, that doesn't initialize the transactions content
     */
    public TransactionHandler() {
    	transactions = new ArrayList<TransactionData>();
    }

    public List<TransactionData> getTransactions() {
        return this.transactions;
    }

    /**
     * readFile
     *
     * Reads in the Bank Account Transaction File,
     * converting the text representations of the Transactions into TransactionData instances.
     *
     * @param file The path to the past day's Merge Bank Account Transaction File.
     */
    public void readFile(String file) {
        // Initialize the File to be used by the scanner
    	File input = new File(file);
    	
    	if (!input.exists()) {
    		System.err.format("ERROR: Transaction file %s does not exist%n", file);
    		System.exit(1);
    	} else {
    		try{
				Scanner reader = new Scanner(input);

				while(reader.hasNextLine()){
					String line = reader.nextLine();
	
					TransactionData temp = new TransactionData(Integer.valueOf(line.substring(0,2)),
	                        line.substring(3, 23), // Might need tweaking depending on how we want to treat whitespace
	                        Integer.valueOf(line.substring(24, 29)),
	                        Float.valueOf(line.substring(30, 38)),
	                        line.substring(39, 41));
					transactions.add(temp);	    		
				}
			
				reader.close();
	
    	} catch (Exception e) {
            System.err.format("ERROR: Transaction File failed to read correctly - %s%n", e.toString());
            e.printStackTrace();
            System.exit(1); //Fatal error, quit program altogether.
        }
    		
        /*try (BufferedReader in = Files.newBufferedReader(Paths.get(file))) { //Currently deprecated BufferedReader code
        
            String line = null;
            while ((line = in.readLine()) != null) {
            	System.out.println();
            	TransactionData temp = new TransactionData(Integer.valueOf(line.substring(0,2)),
                        line.substring(3, 23), // Might need tweaking depending on how we want to treat whitespace
                        Integer.valueOf(line.substring(24, 29)),
                        Float.valueOf(line.substring(30, 38)),
                        line.substring(39, 41));
                transactions.add(temp);
            }

        } */
    	}
    }
}