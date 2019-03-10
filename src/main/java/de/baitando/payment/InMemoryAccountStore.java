package de.baitando.payment;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountStore {

    private static Map<String, Account> accounts;

    public InMemoryAccountStore() {
        accounts = new HashMap<String, Account>();

        Account account1 = new Account();
        account1.iban = "DE123456";
        account1.balance = 1234.12;
        accounts.put(account1.iban, account1);

        Account account2 = new Account();
        account2.iban = "DE654321";
        account2.balance = 4321.21;
        accounts.put(account2.iban, account2);
    }

    public Account getAccountByIban(String iban) {
        return accounts.get(iban);
    }
}
