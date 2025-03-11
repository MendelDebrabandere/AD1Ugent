
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class SimpleTest {

    private static ScoreBord sorter;

    @BeforeClass
    public static void init() {
        sorter = new CountingScoreBord();
    }

    @Test
    public void test1() {
        List<Student> input = Arrays.asList(
                new Student("Marc",0),
                new Student("Sofie",8),
                new Student("An",14),
                new Student("Jean",4),
                new Student("Karl",19),
                new Student("Hans",17),
                new Student("Cedric",0),
                new Student("Maxime",6),
                new Student("Caro",15),
                new Student("Jana",19),
                new Student("Milan",10),
                new Student("Sarah",19),
                new Student("Arnout",1),
                new Student("Jelle",12),
                new Student("Filip",16)
        );
        List<Student> inputKopie = new ArrayList<>(input);
        sorter.sort(input, 20);
        check(Arrays.asList(0, 0, 1, 4, 6, 8, 10, 12, 14, 15, 16, 17, 19, 19, 19), input, inputKopie);
    }

    @Test
    public void test2() {
        List<Student> input = Arrays.asList(
                new Student("Karin",5),
                new Student("Daan",5),
                new Student("Petra",5),
                new Student("Victor",5)
        );
        List<Student> inputKopie = new ArrayList<>(input);
        sorter.sort(input, 20);
        check(Arrays.asList(5, 5, 5, 5), input, inputKopie);
    }

    @Test
    public void test3() {
        List<Student> input = Arrays.asList(
                new Student("Maaike",9),
                new Student("Melissa",20),
                new Student("Hendrik",18),
                new Student("Elise",4),
                new Student("Tom",8),
                new Student("Mario",19),
                new Student("Carla",11),
                new Student("Sandra",20),
                new Student("Maarten",2),
                new Student("Rik",13),
                new Student("Matthias",17),
                new Student("Lars",6),
                new Student("Laurens",13),
                new Student("Nico",8),
                new Student("Ellie",10),
                new Student("Bart",16),
                new Student("Stefan",12),
                new Student("Robbe",13),
                new Student("Bram",1),
                new Student("Hanne",3),
                new Student("Lien",19)
        );
        List<Student> inputKopie = new ArrayList<>(input);
        sorter.sort(input, 20);
        check(Arrays.asList(1, 2, 3, 4, 6, 8, 8, 9, 10, 11, 12, 13, 13, 13, 16, 17, 18, 19, 19, 20, 20),
                input, inputKopie);
    }

    @Test
    public void testEmpty() {
        List<Student> input = new ArrayList<>();
        List<Student> inputKopie = new ArrayList<>(input);
        sorter.sort(input, 20);
        check(Collections.emptyList(), input, inputKopie);
    }

    private void check(List<Integer> punten, List<Student> antw, List<Student> input) {
        Assert.assertEquals("Jouw antwoord heeft een fout aantal elementen.", punten.size(), antw.size());
        Assert.assertTrue("Niet alle studenten zijn aanwezig in jouw antwoord.", antw.containsAll(input));
        for(int i = 0; i < punten.size(); i++) {
            Assert.assertTrue("Jouw lijst is fout gesorteerd.", punten.get(i).intValue() == antw.get(i).getScore());
        }
    }
    
}
