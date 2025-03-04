package Week4.Meerderheidselement;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

    private final Majority maj = new MyMajority();

    @Test
    public void testMajority() {

        Sequence numbers = new Sequence(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4});

        Assert.assertEquals(
                "Incorrect majority element for input: " + numbers + ".",
                4, maj.findMajority(numbers)
        );
        
    }

    @Test
    public void testNoMajority() {

        Sequence numbers = new Sequence(new int[]{3, 3, 4, 2, 4, 4, 2, 4});

        Assert.assertEquals(
                "Incorrect majority element for input: " + numbers + ".",
                -1, maj.findMajority(numbers)
        );



    }

}
