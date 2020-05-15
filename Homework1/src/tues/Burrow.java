package tues;

import java.util.ArrayList;
import java.util.Iterator;

public class Burrow {
    private ArrayList<Food> food = new ArrayList<>();

    public ArrayList<Food> getFood() {
        return food;
    }

    public double getTotalFoodScore() {
        double sum = 0;

        for (int i = 0; i < getFood().size(); i ++) {
            sum += getFood().get(i).getFoodScore();
        }
        return sum;
    }
}
