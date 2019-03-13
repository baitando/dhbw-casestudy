package de.baitando.payment;

import java.util.List;

public class PaymentService {

    private InMemoryAccountStore accountStore;
    private InMemoryPaymentStore paymentStore;

    public PaymentService(InMemoryAccountStore accountStore, InMemoryPaymentStore paymentStore) {
        this.accountStore = accountStore;
        this.paymentStore = paymentStore;
    }

    public boolean transfer(String initiatorIban, String targetIban, Double amount) {
        Account initiator = accountStore.getAccountByIban(initiatorIban);
        Account target = accountStore.getAccountByIban(targetIban);

        initiator.setBalance(initiator.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);

        Payment payment = new Payment(initiator, target);
        paymentStore.addPayment(payment);

        return true;
    }

    public List<Payment> getPayments() {
        return paymentStore.getPayments();
    }
}
