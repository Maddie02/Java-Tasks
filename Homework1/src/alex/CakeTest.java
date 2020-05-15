import  org.junit.Test;
import static org.junit.Assert.*;


public class CakeTest {
    
    @Test
    public void passWinter() {
        Cake cake = new Cake(20, 10);
        assertEquals(cake.getFoodScore(), 200, 0.01);
        
        cake.passWinter();
        assertEquals(cake.getFoodScore(), 137.26, 0.01);
        assertEquals(cake.getAge(), 1);
        
        cake.passWinter();
        assertEquals(cake.getFoodScore(), 47.03, 0.01);
        assertEquals(cake.getAge(), 2);
    }
}