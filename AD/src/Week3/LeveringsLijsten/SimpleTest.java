package Week3.LeveringsLijsten;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;


public class SimpleTest {

    private static LeveringslijstVerwerker lv;
    
    @BeforeClass public static void init() {
        lv = new MijnLeveringslijstVerwerker();
    }
    
    @Test
    public void test1() {
        
        Leverancier l1 = new Leverancier("l1");
        Leverancier l2 = new Leverancier("l2");
        Klant k1 = new Klant("k1");
        Klant k2 = new Klant("k2");
        Klant k3 = new Klant("k3");
        Klant k4 = new Klant("k4");
        Artikel a1 = new Artikel("a1", l1);
        Artikel a2 = new Artikel("a2", l2);
        Artikel a3 = new Artikel("a3", l2);
        
        List<Bestelling> bestellingen = Arrays.asList(
            new Bestelling(k1, a1),
            new Bestelling(k1, a1),
            new Bestelling(k1, a3),
            new Bestelling(k2, a2),
            new Bestelling(k2, a3),
            new Bestelling(k3, a1),
            new Bestelling(k3, a3),
            new Bestelling(k4, a1),
            new Bestelling(k4, a2)  
        );
        
        LeveringslijstVerwerker.LeveringsOverzicht antwStud = lv.getLeveringsLijst(Collections.unmodifiableList(bestellingen));
        
        checkAantalArtikels(antwStud,l1,a1,4);
        checkAantalArtikels(antwStud,l2,a2,2);
        checkAantalArtikels(antwStud,l2,a3,3);
        
        checkBesteldeArtikels(antwStud, l1, Arrays.asList(a1));
        checkBesteldeArtikels(antwStud, l2, Arrays.asList(a2,a3));
   
    }
    
    @Test
    public void test2() {
        
        Leverancier l1 = new Leverancier("l1");
        Leverancier l2 = new Leverancier("l2");
        Klant k1 = new Klant("k1");
        Klant k2 = new Klant("k2");
        Klant k3 = new Klant("k3");
        Klant k4 = new Klant("k4");
        Artikel a1 = new Artikel("a1", l1);
        Artikel a2 = new Artikel("a2", l1);
        Artikel a3 = new Artikel("a3", l1);
        Artikel a4 = new Artikel("a4", l2);
        Artikel a5 = new Artikel("a5", l2);
        Artikel a6 = new Artikel("a6", l2);
        Artikel a7 = new Artikel("a7", l2);
        
        List<Bestelling> bestellingen = Arrays.asList(
            new Bestelling(k1, a1),
            new Bestelling(k1, a1),
            new Bestelling(k1, a3),
            new Bestelling(k1, a5),
            new Bestelling(k1, a6),
            new Bestelling(k2, a2),
            new Bestelling(k2, a3),
            new Bestelling(k2, a4),
            new Bestelling(k2, a5),
            new Bestelling(k3, a1),
            new Bestelling(k3, a3),
            new Bestelling(k3, a5),
            new Bestelling(k4, a1),
            new Bestelling(k4, a2),
            new Bestelling(k4, a7)   
        );
        
        LeveringslijstVerwerker.LeveringsOverzicht antwStud = lv.getLeveringsLijst(Collections.unmodifiableList(bestellingen));
        
        checkAantalArtikels(antwStud,l1,a1,4);
        checkAantalArtikels(antwStud,l1,a2,2);
        checkAantalArtikels(antwStud,l1,a3,3);
        checkAantalArtikels(antwStud,l2,a4,1);
        checkAantalArtikels(antwStud,l2,a5,3);
        checkAantalArtikels(antwStud,l2,a6,1);
        checkAantalArtikels(antwStud,l2,a7,1);
        
        checkBesteldeArtikels(antwStud, l1, Arrays.asList(a1,a2,a3));
        checkBesteldeArtikels(antwStud, l2, Arrays.asList(a4,a5,a6,a7));
   
    }
    
    @Test
    public void test3() {
        
        Leverancier l1 = new Leverancier("l1");
        Leverancier l2 = new Leverancier("l2");
        Leverancier l3 = new Leverancier("l3");
        Klant k1 = new Klant("k1");
        Klant k2 = new Klant("k2");
        Klant k3 = new Klant("k3");
        Artikel a1 = new Artikel("a1", l1);
        Artikel a2 = new Artikel("a2", l1);
        Artikel a3 = new Artikel("a3", l1);
        Artikel a4 = new Artikel("a4", l2);
        Artikel a5 = new Artikel("a5", l3);
        Artikel a6 = new Artikel("a6", l3);
        
        List<Bestelling> bestellingen = Arrays.asList(
            new Bestelling(k1, a1),
            new Bestelling(k1, a3),
            new Bestelling(k1, a6),
            new Bestelling(k2, a2),
            new Bestelling(k2, a3),
            new Bestelling(k2, a4),
            new Bestelling(k2, a5),
            new Bestelling(k3, a1),
            new Bestelling(k3, a3),
            new Bestelling(k3, a5)
        );
        
        LeveringslijstVerwerker.LeveringsOverzicht antwStud = lv.getLeveringsLijst(Collections.unmodifiableList(bestellingen));
        
        checkAantalArtikels(antwStud,l1,a1,2);
        checkAantalArtikels(antwStud,l1,a2,1);
        checkAantalArtikels(antwStud,l1,a3,3);
        checkAantalArtikels(antwStud,l2,a4,1);
        checkAantalArtikels(antwStud,l3,a5,2);
        checkAantalArtikels(antwStud,l3,a6,1);
        
        checkBesteldeArtikels(antwStud, l1, Arrays.asList(a1,a2,a3));
        checkBesteldeArtikels(antwStud, l2, Arrays.asList(a4));
        checkBesteldeArtikels(antwStud, l3, Arrays.asList(a5,a6));
   
    }
    
    public void checkBesteldeArtikels(LeveringslijstVerwerker.LeveringsOverzicht antwStud, Leverancier l, Collection<Artikel> artikelsOpl){
        Collection<Artikel> artikelsStud = antwStud.getBesteldeArtikels(l); 
        Assert.assertEquals("De lengte van de verzameling artikels die besteld worden bij leverancier " + l.getNaam() + " klopt niet:", artikelsOpl.size(), artikelsStud.size());
        Assert.assertTrue("De artikels die besteld worden bij leverancier " + l.getNaam() + " kloppen niet. \n Jouw antwoord: " + artikelsStud + "\n Oplossing: " + artikelsOpl, artikelsStud.containsAll(artikelsOpl));
    }
        
    public void checkAantalArtikels(LeveringslijstVerwerker.LeveringsOverzicht antwStud, Leverancier l, Artikel a, int aantalOpl){
        Assert.assertEquals("Het aantal bestellingen van artikel " + a.getNaam() + " bij leverancier " + l.getNaam() + " klopt niet:", aantalOpl, antwStud.getAantalArtikels(l,a));    
    }
    
}