package de.baitando.payment;

public class PaymentStarter {

    public static void main(String[] args) {

        String initiator = "DE123456";
        String target = "DE654321";

        InMemoryAccountStore accountStore = new InMemoryAccountStore();
        InMemoryPaymentStore paymentStore = new InMemoryPaymentStore();

        PaymentService paymentService = new PaymentService(accountStore, paymentStore);
        paymentService.transfer(initiator, target, 23.34);

        System.out.println(paymentService.getPayments());
    }
}
