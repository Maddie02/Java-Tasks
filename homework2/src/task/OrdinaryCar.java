package task;

import java.util.Random;

public class OrdinaryCar extends Car {
    private Region region;
    private int number = 1000;
    public OrdinaryCar(Model model, int year, int price, EngineType engineType, Region region) {
        super(model, year, price, engineType);
        this.region = region;
        Random random = new Random();
        char character1 = (char) (random.nextInt(26) + 'A');
        char character2 = (char) (random.nextInt(26) + 'A');
        setRegistrationNumber(region.getPrefix() + number + character1 + character2);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
