package main.java.masterbank;

/**
 * MasterBankAccountData
 *
 * TODO: [DESCRIPTION HERE!!!]
 */
public class MasterBankAccountData {
    int number; // constraint of unique bank account
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
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param number TODO: [DESCRIPTION HERE!!!]
     * @param name TODO: [DESCRIPTION HERE!!!]
     * @param status TODO: [DESCRIPTION HERE!!!]
     * @param balance TODO: [DESCRIPTION HERE!!!]
     * @param totalTransactions TODO: [DESCRIPTION HERE!!!]
     * @param studentPlan TODO: [DESCRIPTION HERE!!!]
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
     * dailyTransactions
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param data TODO: [DESCRIPTION HERE!!!]
     */ //WARNING: POSSIBLY DEPRECATED/USELESS, REVIEW AND CONSIDER REMOVING ALTOGETHER
    public void dailyTransactions(MasterBankAccountData data) {

        if (data.studentPlan) {
            //checks to see if account can go negative
            if (data.balance >= (float) (data.totalTransactions * 0.05)) {
                data.balance = data.balance - (float) (data.totalTransactions * 0.05);
            } else {
                System.out.println("ERROR: Account cannot go below 0 "
                        + " Transactions Fee Error Account " + data.name + data.number);
            }

        } else {
            if (data.balance >= (float) (data.totalTransactions * 0.10)) {
                //checks to see if account can go negative
                data.balance = data.balance - (float) (data.totalTransactions * 0.10);
            } else {
                System.out.println("ERROR: Account cannot go below 0 "
                        + " Transactions Fee Error Account " + data.name + data.number);
            }
        }
    }

    /**
     * toString
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param transactionOutput True if the transaction count should be returned (for the purposes of Master Bank Account
     *                          File output), false otherwise.
     * @return The string value of
     */
    public String toString(boolean transactionOutput) {
        if (transactionOutput) {
            return this.number + " " + this.name + " " + this.status + " " + this.balance + " " + this.totalTransactions + " " + this.studentPlan;
        }
        return this.number +" "+ this.name +" "+ this.status +" "+ this.balance +" "+ this.studentPlan;
    }

    /** getBalance
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @return TODO: [DESCRIPTION HERE!!!]
     */
    public float getBalance() {
        return this.balance;
    }

    /**
     * addBalance
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param funds TODO: [DESCRIPTION HERE!!!]
     */
    public void addBalance(float funds) {
        this.balance += funds;
    }

    /**
     * getStudentPlan
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @return TODO: [DESCRIPTION HERE!!!]
     */
    public boolean getStudentPlan() {
        return this.studentPlan;
    }

    /**
     * toggleStatus
     *
     * TODO: [DESCRIPTION HERE!!!]
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
     * TODO: [DESCRIPTION HERE!!!]
     */
    public void togglePlan() {
        this.studentPlan = !this.studentPlan;
    }
}