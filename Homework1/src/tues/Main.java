package tues;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int maxFoodCount = 4;

        ArrayList<Squirrel> squirrels = new ArrayList<>();
        int currentIndex = 0;
        int currentFood = 0;

        while(!next.equals("stop")) {
            var squirrel = readSquirrel(next);
            squirrels.add(squirrel);
            next = scanner.next();
        }
        Scanner sc = new Scanner(System.in);
        String nextFood = sc.nextLine();


        while(!nextFood.equals("stop")) {
            var newFood = readFood(nextFood);

            for (int i = currentIndex; i < squirrels.size(); i ++) {
                squirrels.get(i).addFood(newFood);
                currentFood ++;

                if (currentFood % maxFoodCount == 0) {
                    currentIndex ++;
                }
                break;
            }
            if(squirrels.size() * maxFoodCount == currentFood) {
                currentFood = 0;
                currentIndex = 0;
                for (Squirrel squirrel : squirrels) {
                    squirrel.printSquirrel();
                    squirrel.passWinter();
                    squirrel.printSquirrel();
                }
            }

            nextFood = sc.nextLine();
        }


        for (Squirrel squirrel : squirrels) {
            squirrel.printSquirrel();
        }

    }

    private static Squirrel readSquirrel(String squirrelInput) {
        Scanner scanner = new Scanner(squirrelInput);
        scanner.useDelimiter(",");
        String name = scanner.next();
        String sort = scanner.next();
        int age = scanner.nextInt();
        return new Squirrel(name, sort, age);
    }

    private static Food readFood(String foodInput) {

        var getFood = foodInput.split(" ");

        String sort = getFood[0];
        double quantity = Double.parseDouble(getFood[1]);
        double quality = Double.parseDouble(getFood[2]);

        if (sort.equals("nuts")) {
            return new Nuts(quantity, quality);
        }

        if (sort.equals("cake")) {
            return new Cake(quantity, quality);
        }

        if (sort.equals("mcburger")) {
            return new McBurger(quantity, quality);
        }

        return null;
    }
}
