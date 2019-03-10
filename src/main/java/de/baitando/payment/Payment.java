package de.baitando.payment;

public class Payment {

    String id;
    Account initiator;
    Account target;

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", initiator=" + initiator +
                ", target=" + target +
                '}';
    }
}
