package de.baitando.japs;

import de.baitando.japs.account.persistence.internal.InMemoryAccountStore;
import de.baitando.japs.payment.persistence.internal.InMemoryPaymentStore;
import de.baitando.japs.payment.service.PaymentService;
import de.baitando.japs.payment.service.internal.DefaultPaymentService;

import java.math.BigDecimal;

public class JapsStarter {

    public static void main(String[] args) {

        String initiator = "DE123456";
        String target = "DE654321";

        PaymentService paymentService = new DefaultPaymentService(
                new InMemoryAccountStore(), new InMemoryPaymentStore());
        paymentService.transfer(initiator, target, BigDecimal.valueOf(23.34));

        System.out.println(paymentService.getPayments());
    }
}
