//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class SimpleTest {
//
//    private final Matcher matcher = new MyMatcher();
//
//    @Test
//    public void testOne() {
//        Assert.assertTrue(true);
//        Matcher.Jar jar1 = new Matcher.Jar(1);
//        Matcher.Lid lid1 = new Matcher.Lid(1);
//
//        List<Pair> pairs = matcher.match(
//            Arrays.asList(jar1),
//            Arrays.asList(lid1)
//        );
//
//        Assert.assertEquals(1, pairs.size());
//        Assert.assertEquals(new Pair(jar1, lid1), pairs.get(0));
//    }
//
//    @Test
//    public void testTwo() {
//        // jars
//        Matcher.Jar jar1 = new Matcher.Jar(1);
//        Matcher.Jar jar2 = new Matcher.Jar(2);
//        Matcher.Jar jar3 = new Matcher.Jar(3);
//        // lids
//        Matcher.Lid lid1 = new Matcher.Lid(1);
//        Matcher.Lid lid2 = new Matcher.Lid(2);
//        Matcher.Lid lid3 = new Matcher.Lid(3);
//
//        // match
//        List<Pair> pairs = matcher.match(
//            Collections.unmodifiableList(Arrays.asList(jar3, jar1, jar2)),
//            Collections.unmodifiableList(Arrays.asList(lid1, lid2, lid3))
//        );
//
//        Assert.assertEquals(3, pairs.size());
//        Assert.assertTrue(pairs.contains(new Pair(jar1, lid1)));
//        Assert.assertTrue(pairs.contains(new Pair(jar2, lid2)));
//        Assert.assertTrue(pairs.contains(new Pair(jar3, lid3)));
//    }
//
//    @Test
//    public void testThree() {
//        // jars
//        Matcher.Jar jar1 = new Matcher.Jar(1);
//        Matcher.Jar jar2 = new Matcher.Jar(2);
//        Matcher.Jar jar3 = new Matcher.Jar(3);
//        Matcher.Jar jar4 = new Matcher.Jar(4);
//        Matcher.Jar jar5 = new Matcher.Jar(5);
//        Matcher.Jar jar6 = new Matcher.Jar(6);
//        // lids
//        Matcher.Lid lid1 = new Matcher.Lid(1);
//        Matcher.Lid lid2 = new Matcher.Lid(2);
//        Matcher.Lid lid3 = new Matcher.Lid(3);
//        Matcher.Lid lid4 = new Matcher.Lid(4);
//        Matcher.Lid lid5 = new Matcher.Lid(5);
//        Matcher.Lid lid6 = new Matcher.Lid(6);
//
//        // match
//        List<Pair> pairs = matcher.match(
//                Collections.unmodifiableList(Arrays.asList(jar3, jar1, jar2, jar4, jar5, jar6)),
//                Collections.unmodifiableList(Arrays.asList(lid1, lid2, lid3, lid4, lid5, lid6))
//        );
//
//        Assert.assertEquals(6, pairs.size());
//        Assert.assertTrue(pairs.contains(new Pair(jar1, lid1)));
//        Assert.assertTrue(pairs.contains(new Pair(jar2, lid2)));
//        Assert.assertTrue(pairs.contains(new Pair(jar3, lid3)));
//        Assert.assertTrue(pairs.contains(new Pair(jar4, lid4)));
//        Assert.assertTrue(pairs.contains(new Pair(jar5, lid5)));
//        Assert.assertTrue(pairs.contains(new Pair(jar6, lid6)));
//    }
//
//    @Test
//    public void testFour() {
//        // jars
//        Matcher.Jar jar1 = new Matcher.Jar(1);
//        Matcher.Jar jar2 = new Matcher.Jar(2);
//        Matcher.Jar jar3 = new Matcher.Jar(3);
//        Matcher.Jar jar4 = new Matcher.Jar(3);
//        Matcher.Jar jar5 = new Matcher.Jar(2);
//        Matcher.Jar jar6 = new Matcher.Jar(1);
//        // lids
//        Matcher.Lid lid1 = new Matcher.Lid(1);
//        Matcher.Lid lid2 = new Matcher.Lid(2);
//        Matcher.Lid lid3 = new Matcher.Lid(3);
//        Matcher.Lid lid4 = new Matcher.Lid(3);
//        Matcher.Lid lid5 = new Matcher.Lid(2);
//        Matcher.Lid lid6 = new Matcher.Lid(1);
//
//        // match
//        List<Pair> pairs = matcher.match(
//                Collections.unmodifiableList(Arrays.asList(jar3, jar1, jar2, jar4, jar5, jar6)),
//                Collections.unmodifiableList(Arrays.asList(lid1, lid2, lid3, lid4, lid5, lid6))
//        );
//
//        Assert.assertEquals(6, pairs.size());
//        pairs.forEach(pair -> {
//            Assert.assertEquals(0, pair.getJar().compareTo(pair.getLid()));
//        });
//    }
//
//    @Test
//    public void testFive() {
//        // jars
//        Matcher.Jar jar63 = new Matcher.Jar(63);
//        Matcher.Jar jar5  = new Matcher.Jar(5);
//        Matcher.Jar jar25 = new Matcher.Jar(25);
//        Matcher.Jar jar19 = new Matcher.Jar(19);
//        Matcher.Jar jar93 = new Matcher.Jar(93);
//        Matcher.Jar jar82 = new Matcher.Jar(82);
//        Matcher.Jar jar48 = new Matcher.Jar(48);
//        Matcher.Jar jar70 = new Matcher.Jar(70);
//        Matcher.Jar jar18 = new Matcher.Jar(18);
//        Matcher.Jar jar84 = new Matcher.Jar(84);
//        // lids
//        Matcher.Lid lid63 = new Matcher.Lid(63);
//        Matcher.Lid lid5  = new Matcher.Lid(5);
//        Matcher.Lid lid25 = new Matcher.Lid(25);
//        Matcher.Lid lid19 = new Matcher.Lid(19);
//        Matcher.Lid lid93 = new Matcher.Lid(93);
//        Matcher.Lid lid82 = new Matcher.Lid(82);
//        Matcher.Lid lid48 = new Matcher.Lid(48);
//        Matcher.Lid lid70 = new Matcher.Lid(70);
//        Matcher.Lid lid18 = new Matcher.Lid(18);
//        Matcher.Lid lid84 = new Matcher.Lid(84);
//
//        // match
//        List<Pair> pairs = matcher.match(
//                Collections.unmodifiableList(Arrays.asList(
//                        jar63, jar5, jar25, jar19, jar93, jar82, jar48, jar70, jar18, jar84
//                )),
//                Collections.unmodifiableList(Arrays.asList(
//                        lid18, lid82, lid19, lid93, lid48, lid5, lid84, lid70, lid25, lid63
//                ))
//        );
//
//        Assert.assertEquals(10, pairs.size());
//        pairs.forEach(pair -> {
//            Assert.assertEquals(0, pair.getJar().compareTo(pair.getLid()));
//        });
//    }
//
//    @Test
//    public void testEmpty() {
//        List<Pair> pairs = matcher.match(new ArrayList<>(), new ArrayList<>());
//        Assert.assertEquals(0, pairs.size());
//    }
//
//}
