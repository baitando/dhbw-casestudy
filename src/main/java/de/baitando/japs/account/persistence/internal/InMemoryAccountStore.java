package de.baitando.japs.account.persistence.internal;

import de.baitando.japs.account.model.Account;
import de.baitando.japs.account.persistence.AccountStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * A dummy in-memory implementation of an {@link AccountStore} which stores accounts in-memory. Data ist lost as soon
 * as the application is stopped.
 */
public class InMemoryAccountStore implements AccountStore {

    private Logger log = LoggerFactory.getLogger(InMemoryAccountStore.class);
    private Map<String, Account> accounts;

    public InMemoryAccountStore() {
        accounts = new HashMap<>();

        addAccount(new Account("DE123456", 1234.12));
        addAccount(new Account("DE654321", 4321.21));
    }

    private void addAccount(Account account) {
        accounts.put(account.getIban(), account);
        log.debug("Added new account: '{}'", account);
    }

    @Override
    public Account getAccountByIban(String iban) {
        return accounts.get(iban);
    }
}
