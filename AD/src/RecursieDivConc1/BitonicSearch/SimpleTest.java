//package RecursieDivConc1.BitonicSearch;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class SimpleTest {
//
//    private final BitonicSearcher searcher = new MyBitonicSearcher();
//
//    public void testThem(Sequence numbers, int[] positions) {
//        for(int i = 0; i < 10; i++) {
//            Assert.assertEquals(
//                String.format("%d should be at position %d.", i, positions[i]),
//                positions[i],
//                searcher.bitonicSearch(numbers, i)
//            );
//        }
//    }
//
//    @Test
//    public void testEvensOdds() {
//        Sequence numbers = new Sequence(0, 2, 4, 6, 8, 9, 7, 5, 3, 1);
//        int[] positions = new int[]{ 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
//        testThem(numbers, positions);
//    }
//
//    @Test
//    public void testClimbing() {
//        Sequence numbers = new Sequence(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
//        int[] positions = new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//        testThem(numbers, positions);
//    }
//
//    @Test
//    public void testDescending() {
//        Sequence numbers = new Sequence(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
//        int[] positions = new int[]{ 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
//        testThem(numbers, positions);
//    }
//
//    @Test
//    public void testEmpty(){
//        Assert.assertEquals(
//            "Searcher should always return -1 for empty sequences.",
//            -1, searcher.bitonicSearch(new Sequence(),7)
//        );
//    }
//
//    @Test
//    public void testSizeOnePresent(){
//        Assert.assertEquals(
//            String.format("%d should be at position %d.", 7, 0),
//            0, searcher.bitonicSearch(new Sequence(7),7)
//        );
//    }
//
//    @Test
//    public void testSizeOneNotPresent(){
//        Assert.assertEquals(
//            String.format("%d does not occur in the sequence.", 7),
//            -1, searcher.bitonicSearch(new Sequence(5),7)
//        );
//    }
//
//}
