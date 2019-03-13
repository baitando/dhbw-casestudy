package de.baitando.payment;

import java.util.*;

public class InMemoryPaymentStore {

    private static Map<String, Payment> payments;

    public InMemoryPaymentStore() {
        payments = new HashMap<String, Payment>();
    }

    public void addPayment(Payment payment) {
        String paymentID = UUID.randomUUID().toString();

        payment.setId(paymentID);
        payments.put(payment.getId(), payment);
    }

    public List<Payment> getPayments() {
        return getValues(payments);
    }

    private <T> List<T> getValues(Map<?, T> map) {
        return new ArrayList<>(map.values());
    }
}
