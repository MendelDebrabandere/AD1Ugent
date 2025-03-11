package Inleiding1.DubbelWoorden;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleTest {

    private Doubler doubler;

    @Before public void init() {
        doubler = new MyDoubler();
    }

    @Test
    public void testIsDouble() {
        Assert.assertTrue("'couscous' is a double word", doubler.isDouble("couscous"));
        Assert.assertTrue("'Caucasus' is a double word", doubler.isDouble("Caucasus"));
    }

    @Test
    public void testIsNotDouble() {
        Assert.assertFalse("'rice' is not a double word", doubler.isDouble("rice"));
    }

}
