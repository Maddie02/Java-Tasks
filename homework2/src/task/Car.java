package task;

public abstract class Car implements Comparable<Car> {

    private Model model;
    private int year;
    private int price;
    private EngineType engineType;
    private String registrationNumber;

    public Car(Model model, int year, int price, EngineType engineType) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.engineType = engineType;
    }

    public Model getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Car && compareTo((Car) o) == 0;
    }

    @Override
    public int compareTo(Car car) {
        if (getModel().compareTo(car.getModel()) == 0) {
            return Integer.compare(getYear(), car.getYear());
        }
        return getModel().compareTo((car.getModel()));
    }
}
