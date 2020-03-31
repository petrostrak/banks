package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private List<BankAccount> accounts;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

//    public void setAccounts(List<BankAccount> accounts) {
//        this.accounts = accounts;
//    }
    public void addAccount(BankAccount account){
        if(accounts == null){
            accounts = new ArrayList();
        }
        accounts.add(account);
    }
    
    public void printTotalAmount(){
        double total=0;
        for(BankAccount logariasmo:accounts){
            total += logariasmo.getAmount();
        }
        System.out.println(name+ " has "+total+"€ in his accounts!!!!");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.accounts);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.accounts, other.accounts)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", accounts=" + accounts + '}';
    }
    
    
}
