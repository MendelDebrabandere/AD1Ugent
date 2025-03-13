//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//
//public class SimpleTest {
//
//    @Test
//    public void test1() {
//        Domination domination = new MyDomination();
//        List<Point> input = Arrays.asList(
//                new Point(5,3),
//                new Point(4,5),
//                new Point(2,1),
//                new Point(6,4)
//        );
//        Collection<Point> result = domination.nonDominated(new ArrayList<>(input));
//        Assert.assertEquals(2, result.size());
//        Assert.assertTrue(result.contains(input.get(1)));
//        Assert.assertTrue(result.contains(input.get(3)));
//    }
//
//    @Test
//    public void test2() {
//        Domination domination = new MyDomination();
//        List<Point> input = Arrays.asList(
//                new Point(3,3),
//                new Point(3,2),
//                new Point(8,6),
//                new Point(1,7),
//                new Point(5,5),
//                new Point(3,4)
//            );
//        Collection<Point> result = domination.nonDominated(new ArrayList<>(input));
//        Assert.assertEquals(2, result.size());
//        Assert.assertTrue(result.contains(input.get(2)));
//        Assert.assertTrue(result.contains(input.get(3)));
//    }
//
//    @Test
//    public void test3() {
//        Domination domination = new MyDomination();
//        List<Point> input = Arrays.asList(
//                new Point(8,3),
//                new Point(5,4),
//                new Point(4,6),
//                new Point(2,7),
//                new Point(1,5),
//                new Point(1,9)
//        );
//        Collection<Point> result = domination.nonDominated(new ArrayList<>(input));
//        Assert.assertEquals(5, result.size());
//        Assert.assertTrue(result.contains(input.get(0)));
//        Assert.assertTrue(result.contains(input.get(1)));
//        Assert.assertTrue(result.contains(input.get(2)));
//        Assert.assertTrue(result.contains(input.get(3)));
//        Assert.assertTrue(result.contains(input.get(5)));
//    }
//}
