package banking;

import java.util.Random;

/**
 * Account implementation for consumer (domestic) customers.
 * The account's holder is a {@link Person}.
 */
public class ConsumerAccount extends Account {

    private static Long  accountNumberIndex = 0L; // static variable

    public ConsumerAccount(Person person, Long accountNumber, int pin, double currentBalance) {
        super(person,accountNumber,pin,currentBalance);
        accountNumberIndex++;
    }

    public static Long getAccountNumberIndex(){
        if( accountNumberIndex==0){
            accountNumberIndex=Math.abs(new Random().nextLong());
        }
        return accountNumberIndex;
    }


}
