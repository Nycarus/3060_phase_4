package main.java.transaction;

import main.java.masterbank.*;

import java.util.List;

/**
 * Transaction
 *
 *	class to apply transactions on masterBankAccounts
 *
 */
public final class TransactionHelper {
    /**
     * updateAccounts
     *
     * method which applies all the transactions to each account using applyTransaction()
     * 
     * @param masterBankAccountHandler the class with methods to process MasterBankAccountData
     * @param transactionHandler applies transaction to accounts
     */
    public static void updateAccounts(MasterBankAccountHandler masterBankAccountHandler, TransactionHandler transactionHandler) {
        for (TransactionData transaction : transactionHandler.getTransactions()) {
            applyTransaction(masterBankAccountHandler, transaction);
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
    private static void applyTransaction(MasterBankAccountHandler accountHandler, TransactionData transaction) {
        if (transaction.code != 5) { // If the transaction isn't create
            MasterBankAccountData account = accountHandler.findAccount(transaction.name, transaction.number);

            if (account != null) {
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
            } else { //Notably, create doesn't trigger this, since we expect the account to not exist before creation
                System.out.println("ERROR: Account not found for transaction "+transaction.toString());
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
            funds -= 0.05;
        } else {
            funds -= 0.1;
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
     * Checks to see if account already exists when create transaction is processed
     * creates new account if there is no existing account
     *
     * @param handler The MasterBankAccountHandler containing the account to apply the transactions to.
     * @param data The TransactionData which stores codes to process transactions
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
     * applies delete to the current account being processed
     *
     * @param handler The MasterBankAccountHandler containing the account to apply the transactions to.
     * @param account current account being processed to be deleted
     */
    private static void delete(MasterBankAccountHandler handler, MasterBankAccountData account) {
        List<MasterBankAccountData> removed = handler.getAccounts();
        removed.remove(account);
        handler.setAccounts(removed);
    }

    /**
     * disable
     *
     * changes status of current account being processed
     *
     * @param account current account being processed to be disabled
     */
    private static void disable(MasterBankAccountData account) {
        account.toggleStatus();
    }

    /**
     * changeplan
     *
     * change current plan of account to either student or non-student
     *
     * @param account current account being processed for a changeplan
     */
    private static void changeplan(MasterBankAccountData account) {
        account.togglePlan();
    }
}
