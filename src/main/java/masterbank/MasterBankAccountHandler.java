package main.java.masterbank;

import java.util.List;

public class MasterBankAccountHandler {
    private List<MasterBankAccountData> accounts;

    MasterBankAccountHandler(){
        
    }

    public List<MasterBankAccountData> getAccounts() {
        return this.accounts;
    }

    // Might not be needed
    public MasterBankAccountData findAccount() {
        return null;
    }

    public void readFile(String file) {

    }

    public void writeFile(String file) {

    }
}