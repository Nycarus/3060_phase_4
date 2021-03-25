package main.java.transaction;

import main.java.masterbank.*;

public final class Transaction {

    public static void updateAccounts(MasterBankAccountHandler masterBankAccountHandler, TransactionHandler transactionHandler) {
        for (TransactionData transaction : transactionHandler.getTransactions()) {
            MasterBankAccountData account = masterBankAccountHandler.findAccount();
            startTransaction(account, transaction);
        }
    }

    private static void startTransaction(MasterBankAccountData account, TransactionData transaction) {
        switch (transaction.code){
            case "01":
                break;
            case "02":
                break;
            case "03":
                changeBalance(account, transaction.funds, transaction.miscellaneous);
                break;
            case "04":
                changeBalance(account, transaction.funds, transaction.miscellaneous);
                break;
            case "05":
                changeBalance(account, transaction.funds, transaction.miscellaneous);
                break;
            case "06":
                changeBalance(account, transaction.funds, transaction.miscellaneous);
                break;
            case "07":
                create();
                break;
            case "08":
                delete();
                break;
            case "09":
                disable();
                break;
            case "10":
                changeplan();
                break;
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
        }
    }

    private static Boolean isBalanceZero(float balance, float funds) {
        return balance + funds <= 0;
    }

    private static void create() {

    }

    private static void delete() {

    }

    private static void disable() {

    }

    private static void changeplan() {

    }
}
