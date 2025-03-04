package Week2.ZoekenInGesorteerdeTabel;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;


public class SimpleTest {

    private static TabelControle tc;
    
    @BeforeClass public static void init() {
        tc = new MijnTabelControle();
    }
    
    @Test
    public void test1() {
        
        int[][] input = {{4,10},{6,11}};
        int[][] inputK = kopieerMatrix(input);
        Assert.assertTrue("Je mag de input niet aanpassen.",Arrays.deepEquals(input, inputK));
        Assert.assertEquals(true, tc.controleer(inputK,6));
   
    }

    @Test
    public void test2() {
        
        int[][] input = {{1,4,9},{3,5,10},{6,7,15}};
        int[][] inputK = kopieerMatrix(input);
        Assert.assertTrue("Je mag de input niet aanpassen.",Arrays.deepEquals(input, inputK));
        Assert.assertEquals(false, tc.controleer(inputK,8));
   
    }
    
    @Test
    public void test3() {
            
        int[][] input = {{1,4,9},{3,5,10},{6,7,15}};
        int[][] inputK = kopieerMatrix(input);
        Assert.assertTrue("Je mag de input niet aanpassen.",Arrays.deepEquals(input, inputK));
        Assert.assertEquals(true, tc.controleer(inputK,3));

    }
    
    @Test
    public void test4() {
            
        int[][] input = {{1,4,9,11},{3,5,10,11},{6,7,15,16}};
        int[][] inputK = kopieerMatrix(input);
        Assert.assertTrue("Je mag de input niet aanpassen.",Arrays.deepEquals(input, inputK));
        Assert.assertEquals(false, tc.controleer(inputK,8));

    }
    
    @Test
    public void test5() {
        
        int[][] input = {{1,4,8,11},{3,5,9,12},{4,7,11,12},{7,9,12,14}};
        int[][] inputK = kopieerMatrix(input);
        Assert.assertTrue("Je mag de input niet aanpassen.",Arrays.deepEquals(input, inputK));
        Assert.assertEquals(true, tc.controleer(inputK,7));
        
    }
    
    public int[][] kopieerMatrix(int[][] input){
        int[][] matrixK = new int[input.length][];
        for (int i = 0; i < input.length; i++) {
            matrixK[i] = Arrays.copyOf(input[i], input[i].length);
        }
        return matrixK;
    }

}