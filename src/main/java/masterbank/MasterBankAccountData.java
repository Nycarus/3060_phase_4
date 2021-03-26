package main.java.masterbank;

/**
 * MasterBankAccountData
 *
 * class to store previous/current/future bank account information
 * 
 */
public class MasterBankAccountData {
    int number; 
    String name;
    String status;
    float balance;
    int totalTransactions;
    boolean studentPlan;

    MasterBankAccountData() { // Test without file

    }

    /**
     * MasterBankAccountData
     *
     * 
     *
     * @param number Bank account number
     * @param name name of client
     * @param status Status of account
     * @param balance  Current Amount in account
     * @param totalTransactions transactions summed over time
     *
     */
    public MasterBankAccountData(int number, String name, String status, float balance, int totalTransactions, boolean studentPlan) {

        this.number = number;
        this.name = name;
        this.status = status;
        this.balance = balance;
        this.totalTransactions = totalTransactions;
        this.studentPlan = studentPlan;
    }

  

    /**
     * toString
     *
     * Get results of bank account transaction
     *
     * @param transactionOutput True if the transaction count should be returned (for the purposes of Master Bank Account
     *                          File output), false otherwise.
     * @return The string value of bank account values
     */
    public String toString(boolean transactionOutput) {
        if (transactionOutput) {
            return this.number + " " + this.name + " " + this.status + " " + this.balance + " " + this.totalTransactions + " " + this.studentPlan;
        }
        return this.number +" "+ this.name +" "+ this.status +" "+ this.balance +" "+ this.studentPlan;
    }

    /** getBalance
     *
     * return account balance
     *
     * @return return balance
     */
    public float getBalance() {
        return this.balance;
    }

    /**
     * addBalance
     *
     * add funds to account balance
     *
     * @param funds updates new balance
     */
    public void addBalance(float funds) {
        this.balance += funds;
    }

   
    /**
     * toggleStatus
     *
     * updates status for bank account
     */
    public void toggleStatus() {
        if (this.status == "A") {
            this.status = "D";
        } else {
            this.status = "A";
        }
    }

    /**
     * togglePlan
     *
     * inverts user current student plan check
     */
    public void togglePlan() {
        this.studentPlan = !this.studentPlan;
    }
}