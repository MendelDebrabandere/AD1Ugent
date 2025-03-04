package Week1.Chocoladerepen;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import java.util.Arrays;

public class SimpleTest {

    private ChocolateConsumerPair consumer;

    @Before public void init() {
        consumer = new DarkChocolateConsumerPair();
    }

    @Test
    public void test1() {
        test(new int[]{ 2, 9, 8, 2, 7 }, 2);
    }

    @Test
    public void test2() {
        test(new int[]{ 1, 2, 3, 4, 3, 2, 1 }, 4);
    }
    
    private void test(int[] input, int expected){
        Assert.assertEquals("Input: " + Arrays.toString(input), expected, consumer.consume(input));
    }

}
