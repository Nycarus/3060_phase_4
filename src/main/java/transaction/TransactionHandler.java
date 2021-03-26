package main.java.transaction;

import java.nio.file.Paths;
import java.util.List;
import java.io.BufferedReader;
import java.nio.file.Files;

public class TransactionHandler {
    private List<TransactionData> transactions;

    /**
     * TransactionHandler
     *
     * 0-parameter version of TransactionHandler's initializer, that doesn't initialize the transactions content
     *
     *
     *
     */
    public TransactionHandler() {}

    public List<TransactionData> getTransactions() {
        return this.transactions;
    }

    /**
     * readFile
     *
     * Reads in the Bank Account Transaction File,
     * converting the text representations of the Transactions into TransactionData instances.
     *
     *
     * @param file The path to the past day's Merge Bank Account Transaction File.
     */
    public void readFile(String file) {
        // Initialize the BufferedReader, execute within a try-catch to handle IO errors
        try (BufferedReader in = Files.newBufferedReader(Paths.get(file))) {
        
            String line = null;
            while ((line = in.readLine()) != null) {
                transactions.add(new TransactionData(Integer.valueOf(line.substring(0,2)),
                                                        line.substring(3, 23), // Might need tweaking depending on how we want to treat whitespace
                                                        Integer.valueOf(line.substring(24, 29)),
                                                        Float.valueOf(line.substring(30, 38)),
                                                        line.substring(39, 41)));
            }

        } catch (Exception e) {
            System.err.format("ERROR: Transaction File failed to read correctly - %s%n", e);
            System.exit(1); //Fatal error, quit program altogether.
        }
    }
}