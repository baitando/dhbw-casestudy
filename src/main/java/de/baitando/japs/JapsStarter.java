package de.baitando.japs;

import de.baitando.japs.payment.service.PaymentService;
import de.baitando.japs.payment.service.internal.DefaultPaymentService;

public class JapsStarter {

    public static void main(String[] args) {

        String initiator = "DE123456";
        String target = "DE654321";

        PaymentService paymentService = new DefaultPaymentService();
        paymentService.transfer(initiator, target, 23.34);

        System.out.println(paymentService.getPayments());
    }
}
