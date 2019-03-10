package de.baitando.japs.account.model;

/**
 * Account with all related in information.
 */
public class Account {

    private String iban;
    private Double balance;

    public Account(String iban, Double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public void debit(Double amount) {
        balance -= amount;
    }

    public void credit(Double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + getIban() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }

    public String getIban() {
        return iban;
    }

    public Double getBalance() {
        return balance;
    }
}
