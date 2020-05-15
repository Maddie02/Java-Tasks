package tues;

public class McBurger extends Food {

    public McBurger (double quantity, double quality) {
        super(quantity, quality);
    }

    @Override
    public void passWinter() {
        int currentAge = getAge();
        double currentQuantity = getQuantity();
        double currentQuality = getQuality();

        if (currentAge == 0) {
            double newQuantity = currentQuantity - (0.2 * currentQuantity);
            double newQuality = currentQuality - (0.5 * currentQuality);
            setQuantity(newQuantity);
            setQuality(newQuality);
        }

        setAge(currentAge + 1);

    }
}
