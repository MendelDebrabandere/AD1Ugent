//package RecursieDivConc1.Ltiling;
//
//import java.util.Map;
//import java.util.HashMap;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class SimpleTest {
//
//    @Test public void testOne() {
//        Betegeling b = new DriekwartsBetegeling(0);
//        b.betegel(0, 0);
//        Assert.assertEquals(0, b.tegelnummer(0, 0));
//    }
//
//    public void testBetegeling(int k, int row, int col) {
//        Betegeling b = new DriekwartsBetegeling(k);
//        b.betegel(row, col);
//
//        Assert.assertEquals(String.format("De zijde is niet gelijk aan 2^%d", k),
//                1 << k,
//                b.zijde()
//        );
//
//        Assert.assertEquals(0, b.tegelnummer(row, col));
//
//        /* Controleert enkel of er een correct aantal vakjes per tegelnummer zijn. */
//        Map<Integer, Integer> perTegel = new HashMap<>();
//        for(int r = 0; r < b.zijde(); r++) for(int c = 0; c < b.zijde(); c++) {
//            int tn = b.tegelnummer(r, c);
//            perTegel.put(tn, perTegel.getOrDefault(tn, 0) + 1);
//        }
//        for(Integer tn : perTegel.keySet()) {
//            int verwacht = tn == 0 ? 1 : 3, antwoord = perTegel.get(tn);
//            Assert.assertEquals(
//                String.format("Expected %d tiles numbered %d, but found %d.", verwacht, tn, antwoord),
//                verwacht, antwoord
//            );
//        }
//    }
//
//    @Test public void testTwo() {
//        testBetegeling(1, 0, 1);
//    }
//
//    @Test public void testFour() {
//        testBetegeling(2, 3, 3);
//    }
//
//    @Test public void testEight() {
//        testBetegeling(3, 5, 3);
//    }
//
//    @Test public void testSixteen() {
//        testBetegeling(4, 7, 12);
//    }
//
//    @Test public void testThirtytwo() {
//        testBetegeling(5, 0, 0);
//    }
//
//}
