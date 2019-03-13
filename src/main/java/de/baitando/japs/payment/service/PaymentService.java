package de.baitando.japs.payment.service;

import de.baitando.japs.payment.model.Payment;

import java.math.BigDecimal;
import java.util.List;

/**
 * Offers the possibility to transfer money between accounts.
 */
public interface PaymentService {

    /**
     * Transfer money between two accounts which are identified by their IBAN.
     *
     * @param initiatorIban IBAN of the account which sends money.
     * @param targetIban    IBAN of the account which receives money.
     * @param amount        Amount of money to transfer between the accounts.
     */
    void transfer(String initiatorIban, String targetIban, BigDecimal amount);

    /**
     * Get all payments.
     *
     * @return A list which includes all existing payments.
     */
    List<Payment> getPayments();
}
