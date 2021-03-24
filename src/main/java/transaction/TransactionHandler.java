package main.java.transaction;

import java.util.List;

public class TransactionHandler {
    private List<TransactionData> transactions;

    TransactionHandler() {
        
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
                                                        line[3:23], //TODO: Handle whitespace trimming properly
                                                        Integer.valueOf(line[24:29]),
                                                        Float.valueOf(line[30:38]),
                                                        line[39:41]);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
