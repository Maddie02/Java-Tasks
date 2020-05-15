package task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CarStore {
    /**
     * Adds the specified car in the store.
     * @return true if the car was added successfully to the store
     */
    ArrayList<Car> carStore = new ArrayList<>();

    public ArrayList<Car> getCarStore() {
        return carStore;
    }

    public static class CarNotFoundException extends Exception {}

    public boolean add(Car car) {
        return carStore.add(car);
    }

    /**
     * Adds all of the elements of the specified collection in the store.
     * @return true if the store cars are changed after the execution
     * (i.e. at least one new car is added to the store)
     */
    public boolean addAll(Collection<Car> cars) {
        int oldSize = carStore.size();
        for (var car : cars) {
            carStore.add(car);
        }
        if (oldSize == carStore.size()) {
            return false;
        }
        return true;
    }

    /**
     * Removes the specified car from the store.
     * @return true if the car is successfully removed from the store
     */
    public boolean remove(Car car) {
        return carStore.remove(car);
    }

    /**
     * Finds a car from the store by its registration number.
     * @throws CarNotFoundException if a car with this
     * registration number is not found in the store
     **/
    public Car getCarByRegistrationNumber(String registrationNumber) throws CarNotFoundException {
        for (var car : carStore) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                return car;
            }
        }
        throw new CarNotFoundException();
    }

    /**
     * Returns all cars of a given model.
     * The cars need to be sorted by year of manufacture (in ascending order).
     */
    public Collection<Car> getCarsByModel(Model model) {
        ArrayList<Car> carSameModel = new ArrayList<>();
        for (var car : carStore) {
            if (car.getModel().toString().equals(model.toString())) {
                carSameModel.add(car);
            }
        }
        carSameModel.sort(new YearComparator());
        return carSameModel;
    }

    /**
     * Returns all cars sorted by their natural ordering
     * (according to the implementation of the Comparable<Car> interface).
     **/
    public Collection<Car> getCars() {
        ArrayList<Car> sortedCars = getCarStore();
        Collections.sort(sortedCars);
        return sortedCars;
    }

    /**
     * Returns all cars sorted according to the
     * order induced by the specified comparator.
     */
    public Collection<Car> getCars(Comparator<Car> comparator) {
        ArrayList<Car> sortedCars = getCarStore();
        sortedCars.sort(comparator);
        return sortedCars;
    }

    /**
     * Returns all cars sorted according to the
     * given comparator and boolean flag for order.
     * @param isReversed if true, the cars should be returned in reverse order
     */
    public Collection<Car> getCars(Comparator<Car> comparator,
                                   boolean isReversed) {
        ArrayList<Car> sortedCars = getCarStore();
        sortedCars.sort(comparator);
        if (isReversed) {
            Collections.reverse(sortedCars);
        }
        return sortedCars;
    }

    /**
     * Returns the total number of cars in the store.
     */
    public int getNumberOfCars() {
        return getCarStore().size();
    }

    /**
     * Returns the total price of all cars in the store.
     */
    public int getTotalPriceOfCars() {
        int total = 0;
        for (var car : getCarStore()) {
            total += car.getPrice();
        }
        return total;
    }
}
