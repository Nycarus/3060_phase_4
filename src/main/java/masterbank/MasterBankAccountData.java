package main.java.masterbank;

public class MasterBankAccountData {
    int number; // Can be changed in string
    String name;
    String status;
    float balance;
    int totalTransactions;

    
    MasterBankAccountData() { // Test without file

    }

    MasterBankAccountData(int number, String name, String status, float balance, int totalTransactions) {
        this.number = number;
        this.name = name;
        this.status = status;
        this.balance = balance;
        this.totalTransactions = totalTransactions;
    }
}