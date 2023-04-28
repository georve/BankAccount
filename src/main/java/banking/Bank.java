package banking;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        accounts=new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        long generatedLong = CommercialAccount.getAccountNumberIndex();
        CommercialAccount commercial=new CommercialAccount(company,generatedLong,pin,startingDeposit);
        accounts.put(generatedLong,commercial);
        return generatedLong;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        long generatedLong = ConsumerAccount.getAccountNumberIndex();
        ConsumerAccount commercial=new ConsumerAccount(person,generatedLong,pin,startingDeposit);
        accounts.put(generatedLong,commercial);
        return generatedLong;
    }

    public double getBalance(Long accountNumber) {
      return  accounts.get(accountNumber)!=null?accounts.get(accountNumber).getBalance():-1;
    }

    public void credit(Long accountNumber, double amount) {
       accounts.get(accountNumber).creditAccount(amount);
    }

    public boolean debit(Long accountNumber, double amount) {

        return accounts.get(accountNumber).debitAccount(amount);
    }

    public boolean authenticateUser(Long accountNumber, int pin) {

        return accounts.get(accountNumber).validatePin(pin);
    }
    
    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
       if(accounts.get(accountNumber)!=null && accounts.get(accountNumber) instanceof CommercialAccount){
           ((CommercialAccount) accounts.get(accountNumber)).addAuthorizedUser(authorizedPerson);
       }
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        if(accounts.get(accountNumber)!=null && accounts.get(accountNumber) instanceof CommercialAccount){
      return      ((CommercialAccount) accounts.get(accountNumber)).isAuthorizedUser(authorizedPerson);
        }else{
            return false;
        }
    }

    public Map<String, Double> getAverageBalanceReport() {

        return new HashMap<>();
    }
}
