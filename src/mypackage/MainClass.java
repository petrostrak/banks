package mypackage;

import java.util.ArrayList;

/** @author user */
public class MainClass {

    public static void main(String[] args) {
        BankAccount accountPeiraios = new BankAccount(1, 0.0, "Peiraios");
        accountPeiraios.deposit(100);
        accountPeiraios.printTransactions();
        System.out.println(accountPeiraios.isActive());
        accountPeiraios.withdraw(50);
        accountPeiraios.printTransactions();
        

        
        BankAccount accountEthniki = new BankAccount(2, "Ethniki");
        accountEthniki.deposit(500);
        BankAccount.printAccountsOpened();
        
        
        Person jack = new Person("Jack");
        jack.addAccount(accountEthniki);
        jack.addAccount(accountPeiraios);
        jack.printTotalAmount();
        
    }

}
