package main.java.transaction;

/**
 * TransactionData
 *
 * An object which holds the various attributes of a transaction for ease of access, so conversion from the
 * transaction string itself isn't necessary every time an attribute needs to be accessed.
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
     * Constructor function that initializes every attribute to the given values. Expects all values input to be
     * pre-converted; get the arguments by slicing the transaction into components and converting each.
     *
     * @param code The numeric code used to describe which transaction the data is to be used with.
     *             1 is withdrawal, 2 is transfer, 3 is paybill, 4 is deposit, 5 is create, 6 is delete, 7 is disable,
     *             8 is changeplan, and 0 denotes end of session.
     * @param name The name of the account holder for the account that the transaction operates on.
     * @param number The ID number of the account that the transaction operates on.
     * @param funds The monetary value that the transaction carries, be it credit or debit. Currently, is not expected
     *              to include backend transaction fees (see TransactionHelper's changeBalance method for that).
     * @param miscellaneous Miscellaneous transaction information, likely varies between front-end implementations.
     *                      For example, paybill transaction payees might be denoted here.
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
     * Converts transaction data back to string output, as it is expected to be seen in the Merged Transaction File.
     *
     * @return The string representation of the Transaction Data, as specified for the Bank Account Transaction File.
     */
    public String toString() {
        return String.valueOf(this.code) +" "+ this.name +" "+ String.valueOf(this.number)
                +" "+ String.valueOf(this.funds) +" "+ this.miscellaneous;
    }
}
