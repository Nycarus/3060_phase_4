package main.java.transaction;

public class TransactionData {
    int code; // Can be changed to int
    String name;
    int number;
    float funds;
    String miscellaneous;

    TransactionData() { // Test

    }

    TransactionData(int code, String name, int number, float funds, String miscellaneous) {
        this.code = code;
        this.name = name;
        this.number = number;
        this.funds = funds;
        this.miscellaneous = miscellaneous;
    }
}
