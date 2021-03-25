package main.java.transaction;

import java.util.List;

public class TransactionHandler {
    private List<TransactionData> transactions;

    TransactionHandler() {
        /**
         * TransactionHandler
         *
         * 0-parameter version of TransactionHandler's initializer, that doesn't initialize the transactions content
         *
         *
         *
         */    
    }

    public List<TransactionData> getTransactions() {
        return this.transactions;
    }

    public void readFile(String file) {
        /**
         * readFile
         *
         * Reads in the Bank Account Transaction File, 
         * converting the text representations of the Transactions into TransactionData instances.
         *
         *
         * @arg file The path to the past day's Merge Bank Account Transaction File.
         */

        // Initialize the BufferedReader, execute within a try-catch to handle IO errors
        try (BufferedReader in = Files.newBufferedReader(file)) {
        
            String line = null;
            while ((line = in.readLine()) != null) {
                transactions.append(new TransactionData(Integer.valueOf(line[0:2]), 
                                                        line[3:23], // Might need tweaking depending on how we want to treat whitespace
                                                        Integer.valueOf(line[24:29]),
                                                        Float.valueOf(line[30:38]),
                                                        line[39:41]);
            }

        } catch (Exception e) {
            System.err.format("ERROR: Transaction File failed to read correctly - %s%n", e);
            throw e;
        } finally {
            in.close();
        }
    }
}