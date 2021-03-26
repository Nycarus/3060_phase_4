package main.java.transaction;

/**
 * TransactionData
 *
 * TODO: [DESCRIPTION HERE!!!]
 */
public class TransactionData {
    int code; // Can be changed to int
    String name;
    int number;
    float funds;
    String miscellaneous;

    TransactionData() { // Test

    }

    /**
     * TransactionData
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @param code
     * @param name
     * @param number
     * @param funds
     * @param miscellaneous
     */
    TransactionData(int code, String name, int number, float funds, String miscellaneous) {
        this.code = code;
        this.name = name;
        this.number = number;
        this.funds = funds;
        this.miscellaneous = miscellaneous;
    }

    /**
     * toString
     *
     * TODO: [DESCRIPTION HERE!!!]
     *
     * @return TODO: [DESCRIPTION HERE!!!]
     */
    public String toString() {
        return String.valueOf(this.code) +" "+ this.name +" "+ String.valueOf(this.number)
                +" "+ String.valueOf(this.funds) +" "+ this.miscellaneous;
    }
}
