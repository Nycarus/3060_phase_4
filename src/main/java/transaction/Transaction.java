package main.java.transaction;

import main.java.masterbank.*;

import java.util.List;

/**
 * Transaction
 *
 * TODO: [DESCRIPTION HERE!!!]
 */
public final class Transaction {
    /**
     * updateAccounts
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param masterBankAccountHandler TODO: [DESCRIPTION HERE!!!]
     * @param transactionHandler TODO: [DESCRIPTION HERE!!!]
     */
    public static void updateAccounts(MasterBankAccountHandler masterBankAccountHandler, TransactionHandler transactionHandler) {
        for (TransactionData transaction : transactionHandler.getTransactions()) {
            startTransaction(masterBankAccountHandler, transaction);
        }
    }

    /**
     * startTransaction
     *
     * Encompasses every other transaction type, enacting changes on a given account within the accountHandler unless a constraint is failed.
     *
     * @param accountHandler The MasterBankAccountHandler containing the account to apply the transactions to.
     * @param transaction The transaction to be performed.
     */
    private static void startTransaction(MasterBankAccountHandler accountHandler, TransactionData transaction) {
        if (transaction.code != 5) { // If the transaction isn't create
            MasterBankAccountData account = accountHandler.findAccount();
            switch (transaction.code){
                case 1: //Withdraw
                    if (!changeBalance(account, transaction.funds, "CR")) {
                        System.out.println("ERROR: Constraint failed, balance would be negative for withdrawal transaction "+transaction.toString());
                    }
                    break;
                case 2: //Transfer
                    if (!changeBalance(account, transaction.funds, transaction.miscellaneous)) {
                        System.out.println("ERROR: Constraint failed, balance would be negative for transfer transaction "+transaction.toString());
                    }
                    break;
                case 3: //Paybill
                    if (!changeBalance(account, transaction.funds, "CR")) {
                        System.out.println("ERROR: Constraint failed, balance would be negative for paybill transaction "+transaction.toString());
                    }
                    break;
                case 4: //Deposit
                    if (!changeBalance(account, transaction.funds, transaction.miscellaneous)) {
                        System.out.println("ERROR: Constraint failed, balance would be negative for deposit transaction "+transaction.toString());
                    }
                    break;
                case 6:
                    delete(accountHandler, account);
                    break;
                case 7:
                    disable(account);
                    break;
                case 8:
                    changeplan(account);
                    break;
            }
        } else {
            create(accountHandler, transaction);
        }

    }

    /**
     * changeBalance
     *
     * Multi-purpose function used to facilitate account balance changes for Withdraw, Transfer, Paybill, and Deposit.
     *
     * @param account The account in question to have its balance changed
     * @param funds The amount to change the account balance by (assumed to be positive)
     * @param miscellaneous Taken directly from the transaction in some cases, clarifies whether the transaction is to debit or credit the balance
     *
     * @return false if negative balance constraint fails, true otherwise.
     */
    private static boolean changeBalance(MasterBankAccountData account, float funds, String miscellaneous) {
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
            return false;
        }
        return true;
    }

    /**
     * isBalanceZero
     *
     * Helper function for changeBalance, determines if a balance is negative after adding funds.
     *
     * @param balance The value of the account balance before funds are added.
     * @param funds The value of funds to add to the account balance.
     * @return true if the resulting balance would be negative, false otherwise.
     */
    private static Boolean isBalanceZero(float balance, float funds) {
        return balance + funds < 0.0;
    }

    /**
     * create
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param handler TODO: [DESCRIPTION HERE!!!]
     * @param data TODO: [DESCRIPTION HERE!!!]
     */
    private static void create(MasterBankAccountHandler handler, TransactionData data) {
        if (handler.exists(data.number)) {
            System.out.println("ERROR: Constraint failed, account #"+data.number+" already exists. Transaction "+data.toString());
        } else {
            MasterBankAccountData newAccount = new MasterBankAccountData(data.number, data.name, "A", data.funds, 0, false);
            handler.getAccounts().add(newAccount);
        }
    }

    /**
     * delete
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param handler TODO: [DESCRIPTION HERE!!!]
     * @param account TODO: [DESCRIPTION HERE!!!]
     */
    private static void delete(MasterBankAccountHandler handler, MasterBankAccountData account) {
        List<MasterBankAccountData> removed = handler.getAccounts();
        removed.remove(account);
        handler.setAccounts(removed);
    }

    /**
     * disable
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param account TODO: [DESCRIPTION HERE!!!]
     */
    private static void disable(MasterBankAccountData account) {
        account.toggleStatus();
    }

    /**
     * changeplan
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param account TODO: [DESCRIPTION HERE!!!]
     */
    private static void changeplan(MasterBankAccountData account) {
        account.togglePlan();
    }
}
