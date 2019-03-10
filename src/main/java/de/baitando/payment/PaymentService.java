package de.baitando.payment;

import java.util.List;

public class PaymentService {

    private InMemoryAccountStore accountStore;
    private InMemoryPaymentStore paymentStore;

    public PaymentService() {
        accountStore = new InMemoryAccountStore();
        paymentStore = new InMemoryPaymentStore();
    }

    public boolean transfer(String initiatorIban, String targetIban, Double amount) {
        Account initiator = accountStore.getAccountByIban(initiatorIban);
        Account target = accountStore.getAccountByIban(targetIban);

        initiator.balance -= amount;
        target.balance += amount;

        Payment payment = new Payment();
        payment.initiator = initiator;
        payment.target = target;
        paymentStore.addPayment(payment);

        return true;
    }

    public List<Payment> getPayments() {
        return paymentStore.getPayments();
    }
}
