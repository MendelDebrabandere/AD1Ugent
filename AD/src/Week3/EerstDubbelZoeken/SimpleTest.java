package Week3.EerstDubbelZoeken;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class SimpleTest {

    private static EersteDubbel dubbel;

    @BeforeClass
    public static void init() {
        dubbel = new MijnEersteDubbel();
    }

    @Test
    public void test() {
        Assert.assertEquals(3, dubbel.eersteDubbel(new int[] {1, 3, 5, 5, 8, 3, 2, 5, 8, 3}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, dubbel.eersteDubbel(new int[] {1, 3, 5, 5, 8, 6, 2, 5, 8, 3}));
    }

    @Test
    public void testGrootGetal() {
        Assert.assertEquals(4, dubbel.eersteDubbel(new int[] {208412, 4, 9, 7, 6, 5, 4, 8, 1, 87}));
    }

    @Test
    public void testGeenOpl() {
        Assert.assertEquals(-1, dubbel.eersteDubbel(new int[] {369874, 4, 9, 7, 6, 5, 18, 8, 1, 87}));
    }

    @Test
    public void testLeeg() {
        Assert.assertEquals(-1, dubbel.eersteDubbel(new int[] {}));
    }

}
