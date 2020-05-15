package tues;

public class Cake extends Food {

    public Cake(double quantity, double quality) {
        super(quantity, quality);
    }

    @Override
    public void passWinter() {
        double currentQuantity = getQuantity();
        double currentQuality = getQuality();
        int currentAge = getAge();

        double newQuantity = currentQuantity - (0.3 * currentQuantity);
        double newQuality = currentQuality * (0.1 + 1.99 / (Math.pow(2, (currentAge + 1) / 0.85)));

        setQuantity(newQuantity);
        setQuality(newQuality);
        setAge(currentAge + 1);
    }
}
