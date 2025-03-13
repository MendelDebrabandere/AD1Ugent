//
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//
//public class SimpleTest {
//
//    private static MergeSort sorter;
//
//    @BeforeClass
//    public static void init() {
//        sorter = new NonRecursiveMergeSort();
//    }
//
//    @Test
//    public void test1() {
//        List<Integer> input = Arrays.asList(5, -8, 3, 1, 2, -8, 7, 9, 11, -6);
//        sorter.sort(input);
//        Assert.assertEquals(Arrays.asList(-8, -8, -6, 1, 2, 3, 5, 7, 9, 11), input);
//    }
//
//    @Test
//    public void test2() {
//        List<Integer> input = Arrays.asList(5, 7, 1, 2);
//        sorter.sort(input);
//        Assert.assertEquals(Arrays.asList(1, 2, 5, 7), input);
//    }
//
//    @Test
//    public void test3() {
//        List<Integer> input = Arrays.asList(3, 4, 5, 6, 7, 8);
//        sorter.sort(input);
//        Assert.assertEquals(Arrays.asList(3, 4, 5, 6, 7, 8), input);
//    }
//
//    @Test
//    public void testEmpty() {
//        List<Integer> input = new ArrayList<>();
//        sorter.sort(input);
//        Assert.assertEquals(Collections.emptyList(), input);
//    }
//
//}
