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
            return String.format("%05d",this.number) +" "+ this.name +" "+ this.status +" "+ String.format("%08d",(int)this.balance) +" "+ String.format("%04d",this.totalTransactions);
        }
        return String.format("%05d",this.number) +" "+ this.name +" "+ this.status +" "+ String.format("%08d",(int)this.balance);
    }

    /** getBalance
     *
     * return account balance
     *
     * @return return MasterBankAccountData balance
     */
    public float getBalance() {
        return this.balance;
    }

    /**
     * addBalance
     *
     * add funds to account MasterBankAccountData balance 
     *
     * @param funds  new balance added  
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

    /**
     * getStudentPlan
     *
     * Accessor for this account's student plan.
     *
     * @return true if the account is on a student plan, false if the account is on a non-student plan.
     */
    public boolean getStudentPlan() {
        return this.studentPlan;
    }

    /**
     * getName
     *
     * Accessor for this account's student plan.
     *
     * @return true if the account is on a student plan, false if the account is on a non-student plan.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getNumber
     *
     * Accessor for this account's student plan.
     *
     * @return true if the account is on a student plan, false if the account is on a non-student plan.
     */
    public int getNumber() {
        return this.number;
    }
}