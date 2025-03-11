
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;


public class SimpleTest {

    private static LokaalMinimum lm;
    
    @BeforeClass public static void init() {
        lm = new MijnLokaalMinimum();
    }
    
    @Test
    public void test1() {
        
        int[] input = {3,2,4,5,6,8};
        int[] inputK = Arrays.copyOf(input,6);
        Assert.assertEquals(2, lm.lokaalMinimum(inputK));
        Assert.assertArrayEquals("Je mag de input niet aanpassen.", input, inputK);
   
    }

    @Test
    public void test2() {
        
        int[] input = {9,8,3,2,1,5,6};
        int[] inputK = Arrays.copyOf(input,7);
        Assert.assertEquals(1, lm.lokaalMinimum(inputK));
        Assert.assertArrayEquals("Je mag de input niet aanpassen.", input, inputK);
   
    }
    
    @Test
    public void test3() {
        
        int[] input = {17,16,15,12,11,10,1,-3,-1};
        int[] inputK = Arrays.copyOf(input,9);
        Assert.assertEquals(-3, lm.lokaalMinimum(inputK));
        Assert.assertArrayEquals("Je mag de input niet aanpassen.", input, inputK);
   
    }
    
    @Test
    public void test4() {
        
        int[] input = {-2,2,3,4,5};
        int[] inputK = Arrays.copyOf(input,5);
        Assert.assertEquals(-2, lm.lokaalMinimum(inputK));
        Assert.assertArrayEquals("Je mag de input niet aanpassen.", input, inputK);
   
    }

    @Test
    public void test5() {
        
        int[] input = {10,8,7,6,4,2,-1,-3};
        int[] inputK = Arrays.copyOf(input,8);
        Assert.assertEquals(-3, lm.lokaalMinimum(inputK));
        Assert.assertArrayEquals("Je mag de input niet aanpassen.", input, inputK);
   
    }
}
