import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SimpleTest {

    private final Skyline skyline = new MySkyline();

    @Test
    public void testGebouw() {

        Gebouw g = new Gebouw(4, 7, 12);

        Assert.assertEquals("Incorrecte conversie van gebouw naar skyline.",
                Arrays.asList(new SkylinePunt(4, 12), new SkylinePunt(7, 0)),
                skyline.gebouw(g));

    }

    @Test
    public void testMerge() {

        List<SkylinePunt> s1 = Arrays.asList(
                new SkylinePunt(2, 18),
                new SkylinePunt(12, 0),
                new SkylinePunt(22, 28),
                new SkylinePunt(29, 0)
        );
        List<SkylinePunt> s2 = Arrays.asList(
                new SkylinePunt(17, 15),
                new SkylinePunt(25, 11),
                new SkylinePunt(28, 5),
                new SkylinePunt(30, 0)
        );

        List<SkylinePunt> verwachteMerge = Arrays.asList(
                new SkylinePunt(2, 18),
                new SkylinePunt(12, 0),
                new SkylinePunt(17, 15),
                new SkylinePunt(22, 28),
                new SkylinePunt(29, 5),
                new SkylinePunt(30, 0)
        );

        Assert.assertEquals("Incorrecte merge.", verwachteMerge, skyline.merge(s1, s2));

    }

    @Test
    public void testSkyline() {

        List<Gebouw> gebouwen = Arrays.asList(
                new Gebouw(2, 12, 18),
                new Gebouw(17, 25, 15),
                new Gebouw(21, 28, 11),
                new Gebouw(22, 29, 28),
                new Gebouw(27, 30, 5)
        );

        List<SkylinePunt> verwachteSkyline = Arrays.asList(
                new SkylinePunt(2, 18),
                new SkylinePunt(12, 0),
                new SkylinePunt(17, 15),
                new SkylinePunt(22, 28),
                new SkylinePunt(29, 5),
                new SkylinePunt(30, 0)
        );

        Assert.assertEquals("Incorrecte skyline (zie voorbeeld opgave).", verwachteSkyline, skyline.skyline(gebouwen));

    }
}