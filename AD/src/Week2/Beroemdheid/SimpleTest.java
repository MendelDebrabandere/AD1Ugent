package Week2.Beroemdheid;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

    private static final Random RG = new Random();

    @Test
    public void testZoeker() {
        Zoeker z = new MijnZoeker();

        int size = 5;
        List<Persoon> groep = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Persoon p = new Persoon();
            groep.add(p);
        }

        Persoon beroemd = groep.get(groep.size() - 1);
        for(Persoon p : groep) if(!p.equals(beroemd)) {
            p.registreerKennis(beroemd);
        }

        
        List<Persoon> plebs = new ArrayList<>(groep);
        plebs.remove(groep.size() - 1);
        for (int k = 0; k < 250000; k++) {
            int p1i = RG.nextInt(plebs.size());
            int p2i = RG.nextInt(plebs.size() - 1);
            if (p2i >= p1i) {
                p2i++;
            }
            plebs.get(p1i).registreerKennis(plebs.get(p2i));
        }

        Assert.assertEquals(beroemd, z.zoekBeroemdheid(groep));
    }

    @Test
    public void testKlein(){
        
        Persoon a = new Persoon();
        Persoon b = new Persoon();
        Persoon c = new Persoon();
        Persoon d = new Persoon();
        
        a.registreerKennis(b);
        c.registreerKennis(b);
        d.registreerKennis(b);
        
        b.registreerKennis(a);
        
        Zoeker z = new MijnZoeker();
        List<Persoon> groep = new ArrayList<>(Arrays.asList(a,b,d,c));
        Assert.assertNull("Vergeten checken of de gevonden kandidaat wel degelijk door iedereen gekend is en zelf niemand kent?", z.zoekBeroemdheid(groep));
        
    }

    @Test
    public void testCykel(){
        int n = 100;
        List<Persoon> groep = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Persoon p = new Persoon();
            groep.add(p);
        }

        for (int i = 0; i < n; i++) {
            Persoon p1 = groep.get(i);
            Persoon p2 = groep.get((i+1)%n);
            p1.registreerKennis(p2);
        }

        Zoeker z = new MijnZoeker();
        Assert.assertNull("Er is geen beroemdheid in een cykel.", z.zoekBeroemdheid(groep));
    }

}
