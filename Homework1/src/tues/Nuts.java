package tues;

public class Nuts extends Food {

    public Nuts(double quantity, double quality) {
        super(quantity, quality);
    }

    @Override
    public void passWinter() {
        int currentAge = getAge();
        setAge(currentAge + 1);
    }
}
