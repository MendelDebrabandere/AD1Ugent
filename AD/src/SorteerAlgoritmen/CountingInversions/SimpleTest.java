package SorteerAlgoritmen.CountingInversions;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class SimpleTest {

    private static InversionCounter m = new MyInversionCounter();
    @BeforeClass
    public static void init() {
        m = new MyInversionCounter();
    }

    @Test
    public void test1() {
        int[] rij = new int[] {2,4,3,1,5};
        Assert.assertEquals(4, m.countInversions(rij));
    }

    @Test
    public void test2() {
        int[] rij = new int[] {0,1,2,3,4,5,6,7,8,9,10};
        Assert.assertEquals(0, m.countInversions(rij));
    }

    @Test
    public void test3() {
        int[] rij = new int[] {10,9,8,7,6,5,4,3,2,1,0};
        Assert.assertEquals(55, m.countInversions(rij));
    }

}
