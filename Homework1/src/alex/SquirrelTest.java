import  org.junit.Test;
import static org.junit.Assert.*;

class SquirrelTest {
    Squirrel squirrel = new Squirrel("Test", 5, "Species");

    @Test
    public void passWinter() throws Exception {
        squirrel.addFood(new Nuts(10, 10));
        squirrel.addFood(new Cake(10, 10));
        assertEquals(squirrel.getBurrow().getTotalFoodScore(), 200, 0.1);
        
        squirrel.passWinter();
        assertEquals(squirrel.getBurrow().getTotalFoodScore(), 168.63, 0.01);
        assertEquals(squirrel.getAge(), 6);
        
        squirrel.passWinter();
        assertEquals(squirrel.getBurrow().getTotalFoodScore(), 123.51, 0.01);
        assertEquals(squirrel.getAge(), 7);
    }

    @Test
    public void addFood() {
        try {
            squirrel.addFood(new Nuts(10, 10));
            assertEquals(squirrel.getBurrow().getTotalFoodScore(), 100, 0.1);
            squirrel.addFood(new Nuts(10, 10));
            assertEquals(squirrel.getBurrow().getTotalFoodScore(), 200, 0.1);
            squirrel.addFood(new Nuts(10, 10));
        } catch (Exception e) {
            assertEquals(squirrel.getBurrow().getTotalFoodScore(), 200, 0.1);
        }
    }
}