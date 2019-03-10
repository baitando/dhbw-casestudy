package de.baitando.payment;

public class Account {

    String iban;
    Double balance;

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
