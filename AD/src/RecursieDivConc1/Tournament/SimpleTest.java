//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class SimpleTest {
//
//    private ToernooiPlanner planner = new MijnToernooiPlanner();
//
//    @Test
//    public void test1(){
//        int k = 1;
//        int[][] planning = planner.plan(k);
//        checkPlanning(planning, k);
//    }
//
//    @Test
//    public void test2(){
//        int k = 2;
//        int[][] planning = planner.plan(k);
//        checkPlanning(planning, k);
//    }
//
//    @Test
//    public void test3(){
//        int k = 3;
//        int[][] planning = planner.plan(k);
//        checkPlanning(planning, k);
//    }
//
//    public static void checkPlanning(int[][] planning, int k){
//        int n = 1 << k;
//        Assert.assertEquals(String.format("Planning moet %d dagen (rijen) bevatten.", n - 1), n - 1, planning.length);
//        Set<Integer> gladiators = new HashSet<>();
//        for (int day = 0; day < n - 1; day++) {
//            gladiators.clear();
//            Assert.assertNotNull(String.format("Dag %d heeft geen overeenkomstige rij.", day), planning[day]);
//            Assert.assertEquals(String.format("Dag %d heeft %d kolommen, maar dit moeten er %d zijn.", day, planning[day].length, n), n, planning[day].length);
//            for (int gladiator = 0; gladiator < n; gladiator++) {
//                int opponent = planning[day][gladiator];
//                Assert.assertTrue(String.format("Op dag %d speelt gladiator %d tegen gladiator %d, maar gladiator %d is geen geldige gladiator.", day, gladiator, opponent, opponent), 0 <= opponent && opponent < n);
//                int opponentOpponent = planning[day][opponent];
//                Assert.assertEquals(String.format("Op dag %d speelt gladiator %d tegen gladiator %d, maar gladiator %d speelt dan tegen %d.", day, gladiator, opponent, opponent, opponentOpponent), opponentOpponent, gladiator);
//                Assert.assertTrue(String.format("Op dag %d speelt gladiator %d tegen gladiator %d, maar er speelt al een andere gladiator tegen gladiator %d.", day, gladiator, opponent, opponent), gladiators.add(opponent));
//            }
//        }
//        for (int gladiator = 0; gladiator < n; gladiator++) {
//            gladiators.clear();
//            for (int day = 0; day < n - 1; day++) {
//                int opponent = planning[day][gladiator];
//                Assert.assertNotEquals(String.format("Op dag %d speelt gladiator %d tegen zichzelf.", day, gladiator), gladiator, opponent);
//                Assert.assertTrue(String.format("Op dag %d speelt gladiator %d tegen gladiator %d, maar die hebben al eens tegen elkaar gespleeld in het toernooi.", day, gladiator, opponent), gladiators.add(opponent));
//            }
//        }
//    }
//
//
//}
