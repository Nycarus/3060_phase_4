package main.java.transaction;

import main.java.masterbank.*;

public final class Transaction {

    public static void updateAccounts(MasterBankAccountHandler masterBankAccountHandler, TransactionHandler transactionHandler) {
        for (TransactionData transaction : transactionHandler.getTransactions()) {
            startTransaction(masterBankAccountHandler, transaction);
        }
    }

    private static void startTransaction(MasterBankAccountHandler accountHandler, TransactionData transaction) {
        if (transaction.code != 5) { // If the transaction isn't create
            MasterBankAccountData account = accountHandler.findAccount();
            switch (transaction.code){
                case 1: //Withdraw
                    changeBalance(account, transaction.funds, "CR");
                    break;
                case 2: //Transfer
                    changeBalance(account, transaction.funds, transaction.miscellaneous);
                    break;
                case 3: //Paybill
                    changeBalance(account, transaction.funds, "CR");
                    break;
                case 4: //Deposit
                    changeBalance(account, transaction.funds, transaction.miscellaneous);
                    break;
                case 6:
                    delete();
                    break;
                case 7:
                    disable();
                    break;
                case 8:
                    changeplan();
                    break;
            }
        } else {
            create(accountHandler, transaction);
        }

    }

    private static void changeBalance(MasterBankAccountData account, float funds, String miscellaneous) {
        if (miscellaneous == "DR") {

        }
        else if (miscellaneous == "CR") {
            funds = -funds;
        }

        if (account.getStudentPlan()) {
            funds -= 0.1;
        } else {
            funds -= 0.05;
        }

        if (!isBalanceZero(account.getBalance(), funds)) {
            account.addBalance(funds);
        } else {
            //ERROR
        }
    }

    private static Boolean isBalanceZero(float balance, float funds) {
        return balance + funds <= 0;
    }

    private static void create(MasterBankAccountHandler handler, TransactionData data) {
        if (handler.exists(data.number)) {
            System.out.println("ERROR: Constraint failed, account #"+data.number+" already exists. Transaction "+data.toString());
        }
        MasterBankAccountData newAccount = new MasterBankAccountData(data.number, data.name, "A", data.funds, 0, false);
        handler.getAccounts().add(newAccount);
    }

    private static void delete() {

    }

    private static void disable() {

    }

    private static void changeplan() {

    }
}
