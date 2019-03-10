package de.baitando.japs.payment.persistence.internal;

import de.baitando.japs.payment.model.Payment;
import de.baitando.japs.payment.persistence.PaymentStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * A dummy in-memory implementation of a {@link PaymentStore} which stores payments in-memory. Data ist lost as soon
 * as the application is stopped.
 */
public class InMemoryPaymentStore implements PaymentStore {

    private Logger log = LoggerFactory.getLogger(InMemoryPaymentStore.class);
    private Map<String, Payment> payments;

    public InMemoryPaymentStore() {
        payments = new HashMap<>();
    }

    @Override
    public Payment addPayment(Payment payment) {

        checkExistingPayment(payment);
        checkInvalidId(payment);

        Payment paymentWithId = new Payment(UUID.randomUUID().toString(), payment);
        payments.put(paymentWithId.getId(), paymentWithId);
        log.debug("Added new payment: '{}'", paymentWithId);

        return paymentWithId;
    }

    private void checkExistingPayment(Payment payment) {
        if (payment.getId() != null && payments.containsKey(payment.getId())) {
            throw new IllegalArgumentException("Payment with ID '" + payment.getId() + "' already exists.");
        }
    }

    private void checkInvalidId(Payment payment) {
        if (payment.getId() != null && !payments.containsKey(payment.getId())) {
            throw new IllegalArgumentException("Payment with ID '" + payment.getId() +
                    "' has an ID but is not existing. You must not set the ID.");
        }
    }

    @Override
    public List<Payment> getPayments() {
        return getValues(payments);
    }

    private <T> List<T> getValues(Map<?, T> map) {
        return new ArrayList<>(map.values());
    }
}
