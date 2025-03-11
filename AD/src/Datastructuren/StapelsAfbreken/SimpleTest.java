package Datastructuren.StapelsAfbreken;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void testSimpleCase(){
        int n = 10;
        StackSmasher breker = new GreedyStackSmasher(n, 3);

        breker.registerMove(2, "Arno");
        breker.registerMove(5, "Betty");
        breker.registerMove(5, "Arno");

        Assert.assertEquals(1, breker.score("Betty"));
        Assert.assertEquals(3, breker.score("Arno"));

        Assert.assertEquals(5, breker.destructHighest());

        Assert.assertEquals(1, breker.score("Arno"));
        Assert.assertEquals(0, breker.score("Betty"));
        Assert.assertEquals(-1, breker.score("Carlo"));

        breker.registerMove(2, "Arno");
        breker.registerMove(7,"Betty");
        breker.registerMove(5,"Betty");

        Assert.assertEquals(3, breker.score("Arno"));
        Assert.assertEquals(2, breker.score("Betty"));
    }

    @Test
    public void testMultipleSmashes(){
        int n = 15;
        StackSmasher breker = new GreedyStackSmasher(n, 5);

        breker.registerMove(0, "Arno");
        breker.registerMove(3, "Betty");
        breker.registerMove(3, "Arno");
        breker.registerMove(0, "Arno");

        Assert.assertEquals(1, breker.score("Betty"));
        Assert.assertEquals(5, breker.score("Arno"));

        int destruct = breker.destructHighest();
        Assert.assertTrue(destruct == 0 || destruct == 3);

        int destruct2 = breker.destructHighest();
        Assert.assertEquals(3 - destruct, destruct2);

        Assert.assertEquals(0, breker.score("Arno"));
        Assert.assertEquals(0, breker.score("Betty"));
    }

    @Test
    public void testComplex(){
        int n = 5;
        StackSmasher breker = new GreedyStackSmasher(n, 5);

        breker.registerMove(1, "Arno");
        breker.registerMove(0, "Arno");
        breker.registerMove(2, "Arno");

        breker.registerMove(1, "Arno");
        breker.registerMove(2, "Arno");
        breker.registerMove(2, "Arno");
        breker.registerMove(1, "Arno");
        breker.registerMove(1, "Arno");


        int destruct = breker.destructHighest();
        Assert.assertEquals(1, destruct);

        int destruct2 = breker.destructHighest();
        Assert.assertEquals(2, destruct2);

        int destruct3 = breker.destructHighest();
        Assert.assertEquals(0, destruct3);

        Assert.assertEquals(0, breker.score("Arno"));
    }
}
