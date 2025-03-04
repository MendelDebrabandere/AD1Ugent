package Week3.Formulieren;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SimpleTest {

    private static FormulierTeller teller;

    @BeforeClass
    public static void init() {
        teller = new MijnFormulierTeller();
    }

    @Test
    public void test0() {
        List<String> stemmen = Arrays.asList(
                "Piet",
                "Joris",
                "Piet",
                "Corneel",
                "Piet",
                "Jan",
                "Corneel",
                "Jan",
                "Corneel",
                "Corneel",
                "Corneel"
        );
        Collection<String> antw =  teller.tel(0, Collections.unmodifiableList(stemmen));
        check(antw); // Geen verkozenen
    }

    @Test
    public void test1() {
        List<String> stemmen = Arrays.asList(
            "Piet",
            "Joris",
            "Piet",
            "Corneel",
            "Piet",
            "Jan",
            "Corneel",
            "Jan",
            "Corneel",
            "Corneel",
            "Corneel"
        );
        Collection<String> antw =  teller.tel(2, Collections.unmodifiableList(stemmen));
        check(antw, "Corneel", "Piet");
    }

    @Test
    public void test2() {
        List<String> stemmen = Arrays.asList(
                "Joris",
                "Herman",
                "Nathan",
                "Herman",
                "Joris",
                "Nathan",
                "Nathan",
                "Felix",
                "Felix",
                "Herman",
                "Piet",
                "Herman",
                "Herman",
                "Joris",
                "Felix",
                "Herman",
                "Corneel",
                "Joris"
        );
        Collection<String> antw =  teller.tel(2, Collections.unmodifiableList(stemmen));
        check(antw, "Joris", "Herman");
    }

    @Test
    public void test3() {
        List<String> stemmen = Arrays.asList(
                "Herman",
                "Corneel",
                "Nathan",
                "Felix",
                "Corneel",
                "Margot",
                "Piet",
                "Herman",
                "Felix",
                "Jan",
                "Felix",
                "Herman",
                "Nathan",
                "Herman",
                "Jan",
                "Jan",
                "Piet",
                "Jan",
                "Margot",
                "Herman",
                "Felix",
                "Joris",
                "Jan",
                "Jan",
                "Nathan"
        );
        Collection<String> antw = teller.tel(4, Collections.unmodifiableList(stemmen));
        check(antw, "Felix", "Herman", "Jan", "Nathan");
    }

    @Test
    public void test4() {
        List<String> stemmen = Arrays.asList(
                "Nathan",
                "Margot",
                "Margot",
                "Karen",
                "Felix",
                "Felix",
                "Karen",
                "Herman",
                "Karen",
                "Herman",
                "Karen",
                "Herman",
                "Chloë",
                "Herman",
                "Nathan",
                "Margot",
                "Margot",
                "Herman",
                "Nathan",
                "Felix",
                "Herman",
                "Karen",
                "Karen"
        );
        Collection<String> antw = new HashSet<>(teller.tel(3, Collections.unmodifiableList(stemmen)));
        check(antw, "Herman", "Karen", "Margot");
    }

    public void check(Collection<String> studentAntwoord, String... verwachteVerkozenen) {
        Assert.assertEquals("Je hebt niet het juiste aantal verkozenen bepaald.", verwachteVerkozenen.length, studentAntwoord.size());
        for(String verkozene : verwachteVerkozenen) {
            Assert.assertTrue("Jouw antwoord bevat de verkozene " + verkozene + " niet!", studentAntwoord.contains(verkozene));
        }
    }
    
}
