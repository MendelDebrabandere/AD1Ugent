package Stapels.GrootteVanHaakjes;

import org.junit.Test;
import org.junit.Assert;

public class SimpleTest {

    SizeCalculator fixer = new MySizeCalculator();

    private boolean[] toArray(String haakjes){
        boolean[] openend = new boolean[haakjes.length()];
        for (int i = 0; i < haakjes.length(); i++) {
            openend[i] = haakjes.charAt(i) == '(';
        }
        return openend;
    }

    @Test
    public void testSingle() {
        boolean[] asArray = toArray("()");
        Assert.assertArrayEquals(new int[]{0,0}, fixer.calculateSize(asArray));
    }

    @Test
    public void testDouble() {
        boolean[] asArray = toArray("()()");
        Assert.assertArrayEquals(new int[]{0,0,0,0}, fixer.calculateSize(asArray));
    }

    @Test
    public void testTwo() {
        boolean[] asArray = toArray("(())");
        Assert.assertArrayEquals(new int[]{1,0,0,1}, fixer.calculateSize(asArray));
    }

    @Test
    public void testNested() {
        boolean[] asArray = toArray("((())())");
        Assert.assertArrayEquals(new int[]{2,1,0,0,1,0,0,2}, fixer.calculateSize(asArray));
    }

    @Test
    public void testNested2() {
        boolean[] asArray = toArray("((())()(()))()");
        Assert.assertArrayEquals(new int[]{2,1,0,0,1,0,0,1,0,0,1,2,0,0}, fixer.calculateSize(asArray));
    }

}
