package main.java.backend;

import main.java.masterbank.*;
import main.java.transaction.*;

import java.util.List;

public class Main {
    public void main(String[] args) {
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
        Transaction.updateAccounts(masterBankAccountHandler, transactionHandler);

        // Write to Files
        masterBankAccountHandler.writeFile(masterBankAccountOutputFile);
    }
}