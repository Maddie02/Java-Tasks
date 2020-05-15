package task;

public class StandardCard extends Card {

    public StandardCard(String name, double amount) {
        super(name, amount);
    }

    @Override
    public boolean executePayment(double cost) {
        if (cost > getAmount()) {
            return false;
        }

        setAmount(getAmount() - cost);
        return true;
    }
}
