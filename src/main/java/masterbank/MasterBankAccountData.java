package main.java.masterbank;

public class MasterBankAccountData {
    int number; // constraint of unique bank account
    String name;
    String status;
    float balance;
    int totalTransactions;
    boolean studentPlan;

    MasterBankAccountData() { // Test without file

    }

    public MasterBankAccountData(int number, String name, String status, float balance, int totalTransactions, boolean studentPlan) {

        this.number = number;
        this.name = name;
        this.status = status;
        this.balance = balance;
        this.totalTransactions = totalTransactions;
        this.studentPlan = studentPlan;
    }

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

    public String toString() {
        return this.number + " " + this.name + " " + this.status + " " + this.balance + " " + this.totalTransactions + " " + this.studentPlan;
    }

    public float getBalance() {
        return this.balance;
    }

    public void addBalance(float funds) {
        this.balance += funds;
    }

    public boolean getStudentPlan() {
        return this.studentPlan;
    }
}