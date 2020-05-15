import  org.junit.Test;
import static org.junit.Assert.*;

public class McburgerTest {
    
    @Test
    public void passWinter() {
        Mcburger Mcburger = new Mcburger(20, 10);
        assertEquals(Mcburger.getFoodScore(), 200, 0.01);
        
        Mcburger.passWinter();
        assertEquals(Mcburger.getFoodScore(), 80, 0.01);
        assertEquals(Mcburger.getAge(), 1);
        
        Mcburger.passWinter();
        assertEquals(Mcburger.getFoodScore(), 80, 0.01);
        assertEquals(Mcburger.getAge(), 2);
    }
}