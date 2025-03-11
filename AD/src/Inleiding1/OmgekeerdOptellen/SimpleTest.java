package Inleiding1.OmgekeerdOptellen;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class SimpleTest {

    private ReverseAddition adder;

    @Before
    public void initialize() {
        adder = new MyReverseAddition();
    }

    @Test
    public void oneAndOne() {
        Assert.assertEquals(2, adder.add(1, 1));
    }

    @Test
    public void tenAndOneHundred() {
        Assert.assertEquals(2, adder.add(10, 100));
    }

}
