package de.baitando.japs.account.persistence;

import de.baitando.japs.account.model.Account;

/**
 * Offers actions for saving and loading one or more {@link Account} entities.
 */
public interface AccountStore {

    /**
     * Get a specific account by it's unique IBAN.
     *
     * @param iban The IBAN of the account to load.
     * @return Account corresponding to the IBAN.
     */
    Account getAccountByIban(String iban);
}
