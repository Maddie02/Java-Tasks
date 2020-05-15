package task;

public abstract class Card {
    private String name;
    private double amount;

    public Card(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean feed(double amount) {
        if (amount < 0) {
            return false;
        }

        this.amount += amount;
        return true;
    }

    public abstract boolean executePayment(double cost);
}
