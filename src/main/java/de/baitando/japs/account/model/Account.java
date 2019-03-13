package de.baitando.japs.account.model;

import java.math.BigDecimal;

/**
 * Account with all related in information.
 */
public class Account {

    private String iban;
    private BigDecimal balance;

    public Account(String iban, BigDecimal balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public void debit(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
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

    public BigDecimal getBalance() {
        return balance;
    }
}
