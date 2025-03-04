package Week3.EpidemieOpsporen;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SimpleTest {

    private final EpidemicFinder detector = new MyEpidemicFinder();

    // create some diseases
    Disease cholera = new Disease("cholera");
    Disease dengue = new Disease("dengue");

    @Test
    public void testCholera() {

        // create some diagnoses
        List<Diagnosis> diagnoses = Arrays.asList(
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(dengue, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 2),
                new Diagnosis(cholera, 2),
                new Diagnosis(dengue, 2),
                new Diagnosis(cholera, 2),
                new Diagnosis(cholera, 2)
        );

        // set parameters
        int k = 3;
        int n = 3;

        // find epidemics
        Collection<String> epidemics = detector.findEpidemics(new ArrayList<>(diagnoses), k, n);
        // check
        Assert.assertTrue("There was an undetected cholera epidemic.", epidemics.contains("cholera"));
        Assert.assertEquals("Incorrect number of epidemics reported.", 1, epidemics.size());

    }

    @Test
    public void testDengue() {

        // create some diagnoses
        List<Diagnosis> diagnoses = Arrays.asList(
                new Diagnosis(dengue, 3),
                new Diagnosis(cholera, 0),
                new Diagnosis(dengue, 1),
                new Diagnosis(cholera, 5),
                new Diagnosis(dengue, 2),
                new Diagnosis(cholera, 6),
                new Diagnosis(cholera, 9),
                new Diagnosis(cholera, 2),
                new Diagnosis(cholera, 3),
                new Diagnosis(dengue, 3),
                new Diagnosis(dengue, 3),
                new Diagnosis(dengue, 6),
                new Diagnosis(dengue, 6),
                new Diagnosis(dengue, 4),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(dengue, 1),
                new Diagnosis(dengue, 2),
                new Diagnosis(dengue, 2),
                new Diagnosis(cholera, 0),
                new Diagnosis(dengue, 1),
                new Diagnosis(cholera, 0)
        );

        // set parameters
        int k = 3;
        int n = 2;

        // find epidemics
        Collection<String> epidemics = detector.findEpidemics(new ArrayList<>(diagnoses), k, n);
        // check
        Assert.assertTrue("There was an undetected dengue epidemic.", epidemics.contains("dengue"));
        Assert.assertEquals("Incorrect number of epidemics reported.", 1, epidemics.size());

    }

    @Test
    public void testNone() {

        // create some diagnoses
        List<Diagnosis> diagnoses = Arrays.asList(
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 1),
                // note: there is a gap here!
                new Diagnosis(cholera, 5),
                new Diagnosis(cholera, 5),
                new Diagnosis(cholera, 5),
                new Diagnosis(cholera, 5),
                new Diagnosis(cholera, 6),
                new Diagnosis(cholera, 6),
                new Diagnosis(cholera, 6),
                new Diagnosis(cholera, 6),
                new Diagnosis(cholera, 6)
        );

        // set parameters
        int k = 3;
        int n = 3;

        // find epidemics
        Collection<String> epidemics = detector.findEpidemics(new ArrayList<>(diagnoses), k, n);
        // check
        Assert.assertTrue(
                "No epidemics in case of diagnoses " + diagnoses + ". Reported: " + epidemics + ".",
                epidemics.isEmpty()
        );

    }

    @Test
    public void testNone2() {

        // create some diagnoses
        List<Diagnosis> diagnoses = Arrays.asList(
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 0),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 1),
                new Diagnosis(cholera, 1),
                // note: threshold not exceeded on day 2!
                new Diagnosis(cholera, 2),
                new Diagnosis(cholera, 2),
                // note: again exceeded from here (but not consecutive with day 0 and 1)
                new Diagnosis(cholera, 3),
                new Diagnosis(cholera, 3),
                new Diagnosis(cholera, 3),
                new Diagnosis(cholera, 4),
                new Diagnosis(cholera, 4),
                new Diagnosis(cholera, 4)
        );

        // set parameters
        int k = 3;
        int n = 2;

        // find epidemics
        Collection<String> epidemics = detector.findEpidemics(new ArrayList<>(diagnoses), k, n);
        // check
        Assert.assertTrue(
                "No epidemics in case of diagnoses " + diagnoses + ". Reported: " + epidemics + ".",
                epidemics.isEmpty()
        );

    }


}
