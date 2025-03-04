package Week2.BekersVerwisselen;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.List;

public class SimpleTest {

    private Swapper swapper;

    @Before public void init() {
        swapper = new MinimalSwapper();
    }

    @Test
    public void test1() {
        test(List.of(0,2,1,2),List.of(1,2,0,2), 1);
    }

    @Test
    public void test2() {
        test(List.of(2, 0, 0, 1, 0), List.of(0, 0, 1, 2, 0), 2);
    }

    @Test
    public void test3() {
        test(List.of(1,2,0,2,0,1),List.of(0,1,2,0,2,1), 3);
    }

    @Test
    public void test4() {
        test(List.of(1,1,0,2,0,1,0,1,1,1,2,2,0,2,2,0,0,2,0,1,2),
                List.of(2,2,0,1,0,1,1,2,1,0,2,0,1,1,0,2,2,0,1,2,0),
                9);
    }

    @Test
    public void test5() {
        test(List.of(0,1,2,1),List.of(2,1,0,2), -1);
    }

    @Test
    public void test6() {
        test(List.of(1,1,0,2,0),List.of(2,0,0,0,2), -1);
    }

    private void test(List<Integer> input, List<Integer> original, int expected){
        Assert.assertEquals("Input: " + input + " to " + original,
                expected, swapper.minimalNumberOfSwaps(input, original));
    }

}
