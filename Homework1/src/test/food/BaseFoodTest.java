package test.food;

import tues.Food;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseFoodTest {
    @Test
    void getFoodScore() {
        Food food = new Food(10, 10) {
            public void passWinter() {}
        };

        assertEquals(food.getFoodScore(), 100);

        food = new Food(20, 10) {
            public void passWinter() {}
        };
        assertEquals(food.getFoodScore(), 200);

        food = new Food(10, 20) {
            public void passWinter() {}
        };
        assertEquals(food.getFoodScore(), 200);
    }
}
