package de.baitando.japs.payment.model;

import de.baitando.japs.account.model.Account;

/**
 * Describes a specific transfer of money from one account to the other.
 */
public class Payment {

    private String id;
    private Account initiator;
    private Account target;

    /**
     * Create the payment based on an existing one and set the ID.
     *
     * @param id      ID of the payment. Should be defined by the one who stores the payment.
     * @param payment The original payment.
     */
    public Payment(String id, Payment payment) {
        this.id = id;
        this.initiator = payment.getInitiator();
        this.target = payment.getTarget();
    }

    /**
     * Crate the payment with both accounts and the amount set.
     *
     * @param initiator Initiator {@link Account} of the payment.
     * @param target    Target {@link Account} of the payment.
     */
    public Payment(Account initiator, Account target) {
        this.initiator = initiator;
        this.target = target;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + getId() + '\'' +
                ", initiator=" + getInitiator() +
                ", target=" + getTarget() +
                '}';
    }

    public String getId() {
        return id;
    }

    public Account getInitiator() {
        return initiator;
    }

    public Account getTarget() {
        return target;
    }
}
