package Datastructuren.LeveringsLijsten;

import java.util.Collection;
import java.util.List;


public interface LeveringslijstVerwerker {
    
    public LeveringsOverzicht getLeveringsLijst(List<Bestelling> bestellingen);
    
    public interface LeveringsOverzicht{
        public Collection<Artikel> getBesteldeArtikels(Leverancier l);
        public int getAantalArtikels(Leverancier l, Artikel a);
    }
    
}
