package Week3.OzonGehalte;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;


public class SimpleTest {

    private static OzonAnalyse oa;
    
    @BeforeClass public static void init() {
        oa = new MijnOzonAnalyse();
    }
    
    @Test
    public void test1() {
        
        List<Meting> metingen = Arrays.asList(
            //DAG 1
            new Meting("Gent",90.1),
            new Meting("Antwerpen",120.9),
            new Meting("Brussel",181.1),
            new Meting("Brugge",70.7),
            //DAG 2
            new Meting("Gent",150.50),
            new Meting("Antwerpen",190.3),
            new Meting("Brussel",179.4),
            new Meting("Brugge",120.2),
            //DAG 3
            new Meting("Gent",190.2),
            new Meting("Antwerpen",185.1),
            new Meting("Brussel",200.1),
            new Meting("Brugge",110.1),
            //DAG 4
            new Meting("Gent",160.4),
            new Meting("Antwerpen",162.1),
            new Meting("Brussel",190.9),
            new Meting("Brugge",120.1),
            //DAG 5
            new Meting("Gent",180.7),
            new Meting("Antwerpen",125.3),
            new Meting("Brussel",190.1),
            new Meting("Brugge",177.5)
        );
        
        Collection<String> antwStud = oa.risicoGebieden(Collections.unmodifiableList(metingen), 2, 180);

        Collection<String> opl = Arrays.asList("Brussel");
        
        Assert.assertEquals("Het aantal risicogebieden in je antwoord klopt niet: ", 1, antwStud.size());
        Assert.assertTrue("De risicogebieden in je antwoord kloppen niet. \nJouw antwoord: " + antwStud + "\nDe oplossing: " + opl, antwStud.containsAll(opl));
        
    }
    
    @Test
    public void test2() {
        
        List<Meting> metingen = Arrays.asList(
            //DAG 1
            new Meting("Gent",90.1),
            new Meting("Antwerpen",120.9),
            new Meting("Brussel",181.1),
            new Meting("Brugge",70.7),
            //DAG 2
            new Meting("Gent",150.50),
            new Meting("Antwerpen",190.3),
            new Meting("Brussel",179.4),
            new Meting("Brugge",120.2),
            //DAG 3
            new Meting("Gent",190.2),
            new Meting("Antwerpen",185.1),
            new Meting("Brussel",200.1),
            new Meting("Brugge",110.1),
            //DAG 4
            new Meting("Gent",160.4),
            new Meting("Antwerpen",182.1),
            new Meting("Brussel",190.9),
            new Meting("Brugge",120.1),
            //DAG 5
            new Meting("Gent",180.7),
            new Meting("Antwerpen",125.3),
            new Meting("Brussel",190.1),
            new Meting("Brugge",177.5)
        );
        
        Collection<String> antwStud = oa.risicoGebieden(Collections.unmodifiableList(metingen), 1, 180);
        
        Collection<String> opl = Arrays.asList("Antwerpen", "Gent", "Brussel");
        
        Assert.assertEquals("Het aantal risicogebieden in je antwoord klopt niet: ", 3, antwStud.size());
        Assert.assertTrue("De risicogebieden in je antwoord kloppen niet. \nJouw antwoord: " + antwStud + "\nDe oplossing: " + opl, antwStud.containsAll(opl));
        
    }
    
    
    @Test
    public void test3() {
        
        List<Meting> metingen = Arrays.asList(
            //DAG 1
            new Meting("Gent",90.1),
            new Meting("Antwerpen",120.9),
            new Meting("Brussel",181.1),
            new Meting("Brugge",70.7),
            //DAG 2
            new Meting("Gent",150.50),
            new Meting("Antwerpen",190.3),
            new Meting("Brussel",179.4),
            new Meting("Brugge",120.2),
            //DAG 3
            new Meting("Gent",190.2),
            new Meting("Antwerpen",185.1),
            new Meting("Brussel",200.1),
            new Meting("Brugge",110.1),
            //DAG 4
            new Meting("Gent",160.4),
            new Meting("Antwerpen",182.1),
            new Meting("Brussel",190.9),
            new Meting("Brugge",120.1),
            //DAG 5
            new Meting("Gent",180.7),
            new Meting("Antwerpen",125.3),
            new Meting("Brussel",190.1),
            new Meting("Brugge",177.5),
            //DAG 6
            new Meting("Gent",155.2),
            new Meting("Antwerpen",199.2),
            new Meting("Brussel",200.1),
            new Meting("Brugge",160.1),
            //DAG 7
            new Meting("Gent",145.2),
            new Meting("Antwerpen",179.2),
            new Meting("Brussel",170.1),
            new Meting("Brugge",150.1),
            //DAG 8
            new Meting("Gent",185.2),
            new Meting("Antwerpen", 190.2),
            new Meting("Brussel",185.3),
            new Meting("Brugge",160.7)
        );
        
        Collection<String> antwStud = oa.risicoGebieden(Collections.unmodifiableList(metingen), 3, 180);
        
        Collection<String> opl = Arrays.asList("Antwerpen", "Brussel");
        
        Assert.assertEquals("Het aantal risicogebieden in je antwoord klopt niet: ", 2, antwStud.size());
        Assert.assertTrue("De risicogebieden in je antwoord kloppen niet. \nJouw antwoord: " + antwStud + "\nDe oplossing: " + opl, antwStud.containsAll(opl));
    
    }
}
