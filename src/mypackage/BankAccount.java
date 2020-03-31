package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankAccount {

    private int number;
    private double amount;
    private String name;
    private boolean active;
    private List<String> transactions;
    private static int accountsOpened;

    public BankAccount() {
        openAccount();
        //accountsOpened++;
    }

    public BankAccount(int number, String name) {
        this();
        this.number = number;
        this.name = name;
        transactions.add("Created BankAccount with number:" + number + " and name:" + name);
    }

    public BankAccount(int number, double amount, String name) {
        this(number, name);
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

//    public void setAmount(double amount) {
//        this.amount = amount;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public static void printAccountsOpened() {
        System.out.println(accountsOpened+" accounts have been created!!");
        
    }

//    public void setTransactions(List<String> transactions) {
//        this.transactions = transactions;
//    }
    
    private void openAccount() {
        this.transactions = new ArrayList();
        active = true;
        accountsOpened++;
    }

    public double deposit(double depositAmount) {
        this.amount += depositAmount;
        String message = String.format("Deposit amount:%.2f€, Total amount:%.2f€", depositAmount, this.amount);
        transactions.add(message);
        return this.amount;
    }

    public double withdraw(double poso) {
        //if poso more than amount, then fere to amount
        //else do it normal
        if (this.amount < poso) {
            poso = this.amount;
            this.amount = 0;
        } else {
            this.amount -= poso;
        }
        String message = String.format("Withdraw amount:%.2f€, Total amount:%.2f€", poso, amount);
        transactions.add(message);
        return this.amount;
    }

    public void printTransactions() {
        int counter = 1;
        System.out.println("\n***Printing transactions of account " + name + "***");
        for (String transaction : transactions) {
            System.out.println(counter + ". " + transaction);
            counter++;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.number;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + (this.active ? 1 : 0);
        hash = 19 * hash + Objects.hashCode(this.transactions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankAccount other = (BankAccount) obj;
        if (this.number != other.number) {
            return false;
        }
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.transactions, other.transactions)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "number=" + number + ", amount=" + amount + ", name=" + name + ", active=" + active + ", transactions=" + transactions + '}';
    }

}
