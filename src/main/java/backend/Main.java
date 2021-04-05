package main.java.backend;

import main.java.masterbank.*;
import main.java.transaction.*;

/**
 * Main
 *
 * Responsible for running and utilizing the constructed classes to create a functioning back-end.
 */
public class Main {
    public static void main(String[] args) {
        String masterBankAccountInputFile = args[0];
        String transactionInputFile = args[1];
        String accountOutputFile = args[2];
        String masterBankAccountOutputFile = args[3];

        MasterBankAccountHandler masterBankAccountHandler = new MasterBankAccountHandler();
        TransactionHandler transactionHandler = new TransactionHandler();

        // Read Files
        masterBankAccountHandler.readFile(masterBankAccountInputFile);
        transactionHandler.readFile(transactionInputFile);
        // update bank accounts
        TransactionHelper.updateAccounts(masterBankAccountHandler, transactionHandler);

        // Write to Files
        masterBankAccountHandler.writeFile(masterBankAccountOutputFile);
    }
}