package task;

public class GoldenCard extends Card {

    public GoldenCard(String name, double amount) {
        super(name, amount);
    }

    @Override
    public boolean executePayment(double cost) {
        if (getAmount() >= cost) {
            setAmount(getAmount() - cost);
            double bonus = 0.15 * cost;
            setAmount(getAmount() + bonus);
            return true;
        }
        return false;
    }
}
