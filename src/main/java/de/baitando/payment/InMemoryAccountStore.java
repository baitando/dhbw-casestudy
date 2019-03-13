package de.baitando.payment;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountStore {

    private static Map<String, Account> accounts;

    public InMemoryAccountStore() {
        accounts = new HashMap<String, Account>();

        Account account1 = new Account("DE123456", 1234.12);
        accounts.put(account1.getIban(), account1);

        Account account2 = new Account("DE654321",4321.21);
        accounts.put(account2.getIban(), account2);
    }

    public Account getAccountByIban(String iban) {
        return accounts.get(iban);
    }
}
