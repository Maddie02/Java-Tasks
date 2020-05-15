package task;

public class Main {

    public static void main(String[] args) {
        Car car1 = new OrdinaryCar(Model.AUDI, 1996, 45674, EngineType.DIESEL, Region.SOFIA );
        Car car3 = new OrdinaryCar(Model.BMW, 2007, 500, EngineType.GASOLINE, Region.VARNA );
        Car car5 = new SportsCar(Model.FERRARI, 2020, 2345678, EngineType.ELECTRIC, Region.SOFIA );

        CarStore store = new CarStore();
        store.add(car1);
        store.add(car3);
        store.add(car5);

        for (var cars : store.getCarStore()) {
            System.out.println(cars.getRegistrationNumber());
        }
    }
}
