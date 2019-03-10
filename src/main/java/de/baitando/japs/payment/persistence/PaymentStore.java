package de.baitando.japs.payment.persistence;

import de.baitando.japs.payment.model.Payment;

import java.util.List;

/**
 * Offers actions for saving and loading one or more @{@link Payment} entities.
 */
public interface PaymentStore {

    /**
     * Add a new japs.
     *
     * @param payment The new japs to persist.
     * @return The stored payment incl. it's ID.
     * @throws IllegalArgumentException Payment was already stored.
     */
    Payment addPayment(Payment payment);

    /**
     * Get all existing payments.
     *
     * @return A list of all existing payments.
     */
    List<Payment> getPayments();
}
