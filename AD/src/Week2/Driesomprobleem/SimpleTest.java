package Week2.Driesomprobleem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;


public class SimpleTest {

    private static DrieSomProbleem dsp;
    
    
    @BeforeClass public static void init() {
        dsp = new MijnDrieSomProbleem();
    }
    
    @Test
    public void test1() {
        //Er wordt verondersteld dat de invoer gesorteerd is!
        List<Integer> invoer = Arrays.asList(
                -5, 1, 2, 3, 7, 8
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        TripletIndices oplTriplet = new TripletIndices(0, 2, 3);
        Assert.assertEquals(oplTriplet, antwTriplet);
        
    }

    @Test
    public void test2() {
        List<Integer> invoer = Arrays.asList(
              -16, -3, 2, 3, 5, 6, 7, 19
        );  

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));
        
        TripletIndices oplTriplet = new TripletIndices(0, 1, 7);
        Assert.assertEquals(oplTriplet, antwTriplet);
        
    }
    
    @Test
    public void test3() {
        List<Integer> invoer = Arrays.asList(
                -16, -3, 2, 3, 5, 6, 7
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        Assert.assertNull(antwTriplet);
        
    }


    @Test
    public void test4() {
        List<Integer> invoer = Arrays.asList(
               -9, -8, -3, -1, 2, 5, 7, 13, 18
        );
        
        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));
        
        TripletIndices oplTriplet = new TripletIndices(0, 4, 6);
        Assert.assertEquals(oplTriplet, antwTriplet);

    }

    @Test
    public void test5() {
        List<Integer> invoer = Arrays.asList(
            -4, -4, -2, 3, 5, 8, 10
        );
        
        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));
        
        TripletIndices oplTriplet = new TripletIndices(0, 1, 5);
        Assert.assertEquals(oplTriplet, antwTriplet);

    }

    @Test
    public void test6() {
        List<Integer> invoer = Arrays.asList(
                -4, -4, 3, 5, 9, 10
        );
        
        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        Assert.assertNull(antwTriplet);
        
    }

    @Test
    public void test7() {
        List<Integer> invoer = Arrays.asList(
                -6, 3, 4, 5
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        Assert.assertNull(antwTriplet);

    }

    @Test
    public void test8(){
        List<Integer> invoer = Arrays.asList(
                -10, 5, 8
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        Assert.assertNull(antwTriplet);
    }

    @Test
    public void test9(){
        List<Integer> invoer = Arrays.asList(
                -10, -2, -1, 3, 8
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        Assert.assertEquals(new TripletIndices(1,2,3), antwTriplet);
    }


    @Test
    public void test10(){
        List<Integer> invoer = Arrays.asList(
                -26, -26, -25, -23, -23, -23, -20, -20, -20, -15, 13, 13, 14, 16, 17, 17, 20, 21, 21, 22
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        Assert.assertNotNull(antwTriplet);
    }

    @Test
    public void test11(){
        List<Integer> invoer = Arrays.asList(
                -10, 0, 0, 0, 1, 2, 3
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        Assert.assertNotNull(antwTriplet);
    }
}