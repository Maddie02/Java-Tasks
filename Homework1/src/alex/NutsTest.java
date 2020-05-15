import  org.junit.Test;
import static org.junit.Assert.*;

public class NutsTest {
    @Test
    public void passWinter() {
        Nuts nuts = new Nuts(20, 10);
        assertEquals(nuts.getFoodScore(), 200, 0.01);
        
        nuts.passWinter();
        assertEquals(nuts.getFoodScore(), 200, 0.01);
        assertEquals(nuts.getAge(), 1);
        
        nuts.passWinter();
        assertEquals(nuts.getFoodScore(), 200, 0.01);
        assertEquals(nuts.getAge(), 2);
    }
}