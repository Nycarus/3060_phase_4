package main.java.masterbank;

public class MasterBankAccountData {
    int number; // Can be changed in string
    String name;
    String status;
    float balance;
    int totalTransactions;
    boolean studentPlan;
  



    
    MasterBankAccountData() { // Test without file

    }

    MasterBankAccountData(int number, String name, String status, float balance, int totalTransactions,boolean studentPlan) {
        this.number = number;
        this.name = name;
        this.status = status;
        this.balance = balance;
        this.totalTransactions = totalTransactions;
        this.studentPlan=studentPlan;
    }

    public void dailyTransactions(MasterBankAccountData data) {
       if(data.studentPlan== true){
          data.balance=data.balance - (float)(data.totalTransactions*0.05);

       }
       else{
        data.balance=data.balance - (float)(data.totalTransactions*0.10);
       }

    }




}