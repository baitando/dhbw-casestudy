package de.baitando.japs.payment.service.internal;

import de.baitando.japs.account.model.Account;
import de.baitando.japs.account.persistence.AccountStore;
import de.baitando.japs.account.persistence.internal.InMemoryAccountStore;
import de.baitando.japs.payment.model.Payment;
import de.baitando.japs.payment.persistence.PaymentStore;
import de.baitando.japs.payment.persistence.internal.InMemoryPaymentStore;
import de.baitando.japs.payment.service.PaymentService;

import java.util.List;

/**
 * The default implementation of a {@link PaymentService} which processes payments.
 */
public class DefaultPaymentService implements PaymentService {

    private AccountStore accountStore;
    private PaymentStore paymentStore;

    public DefaultPaymentService() {
        accountStore = new InMemoryAccountStore();
        paymentStore = new InMemoryPaymentStore();
    }

    @Override
    public void transfer(String initiatorIban, String targetIban, Double amount) {
        Account initiator = accountStore.getAccountByIban(initiatorIban);
        Account target = accountStore.getAccountByIban(targetIban);

        initiator.debit(amount);
        target.credit(amount);

        paymentStore.addPayment(new Payment(initiator, target));
    }

    @Override
    public List<Payment> getPayments() {
        return paymentStore.getPayments();
    }
}
