package task;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(42);
        int i = (int) list.iterator().next();
        System.out.println(i);

        List<Integer> integersList = new LinkedList<Integer>();
        integersList.add(42);
        int integer = integersList.iterator().next();
        System.out.println(integer);

        Box<Integer> box = new Box();
        box.setValue(42);
        int value = box.getValue();
        System.out.println(value);

        Pair<Integer, String> pair1 = new Pair<>(1, "a1");
        Pair<Integer, String> pair2 = new Pair<>(1, "a1");
        System.out.println(pair1.getValue());

        System.out.println(Utils.areEqual(pair1, pair2));

        List<Integer> integers = Arrays.asList(1, 2, 3);
        printCollection(integers);

        List<Object> objects = new ArrayList<>();
    }

    private static void printCollection(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    private static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        for (var n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }

    private static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i < 10; i ++) {
            list.add(i);
        }
    }
}
