package RecursieDivConc.MaximumInCirculairVerschovenRij;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class SimpleTest {

    private static MaximumBepaler m;

    @BeforeClass
    public static void init() {
        m = new MijnMaximumBepaler();
    }

    @Test
    public void test1() {
        Assert.assertEquals(42, m.bepaalMaximum(35, 42, 5, 15, 27, 29));
    }

    @Test
    public void test2() {
        int[] rij = new int[] {5, 7, 9, 11, 12, 14, 2, 3, 4};
        // Voor elke verschuiving controleren of de juiste oplossing wordt gegeven
        for(int i = 0; i < rij.length; i++) {
            int[] rij2 = new int[rij.length];
            for(int j = 0; j < rij.length; j++) {
                rij2[j] = rij[(j+i)%rij.length];
            }
            Assert.assertEquals(14, m.bepaalMaximum(rij2));
        }
    }

    @Test
    public void test3() {
        Assert.assertEquals(8, m.bepaalMaximum(8));
    }

    @Test
    public void test4() {
        Assert.assertEquals(4, m.bepaalMaximum(-3,4));
    }

    @Test
    public void test5() {
        Assert.assertEquals(-3, m.bepaalMaximum(-4,-3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLegeRij() {
        m.bepaalMaximum();
    }
    
}
