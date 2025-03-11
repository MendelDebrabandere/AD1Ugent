package Inleiding2.Feestje;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleTest {

    private final Party party = new MyParty();

    @Test
    public void testMoreHelpersNeeded() {

        int start = 592;
        int stop = 700;

        Interval carine = new Interval(592, 628);
        Interval dina = new Interval(646, 700);
        Interval erik = new Interval(556, 610);
        Interval frank = new Interval(631, 643);

        List<Interval> helpers = Arrays.asList(carine, dina, erik, frank);

        Assert.assertFalse(
                String.format("Helpers %s are NOT enough for my party from %d until %d.", helpers, start, stop),
                party.check(new ArrayList<>(helpers), start, stop)
        );
        
    }

    @Test
    public void testHelpersOk() {

        int start = 592;
        int stop = 700;

        Interval carine = new Interval(592, 628);
        Interval dina = new Interval(646, 700);
        Interval erik = new Interval(556, 610);
        Interval frank = new Interval(592, 646);

        List<Interval> helpers = Arrays.asList(carine, dina, erik, frank);

        Assert.assertTrue(
                String.format("Helpers %s are enough for my party from %d until %d.", helpers, start, stop),
                party.check(new ArrayList<>(helpers), start, stop)
        );

    }


}
