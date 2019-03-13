package de.baitando.payment;

public class Payment {

    private String id = null;
    private Account initiator;
    private Account target;

    public Payment(Account initiator, Account target) {
        this.initiator = initiator;
        this.target = target;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", initiator=" + initiator +
                ", target=" + target +
                '}';
    }
}
