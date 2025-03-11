package Datastructuren.LeveringsLijsten;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MijnLeveringslijstVerwerker implements LeveringslijstVerwerker{
    @Override
    public LeveringsOverzicht getLeveringsLijst(List<Bestelling> bestellingen) {

        HashMap<Leverancier, HashMap<Artikel, Integer>> data = new HashMap<>();


        for (Bestelling bestelling : bestellingen) {

            Artikel artikel = bestelling.getArtikel();
            Leverancier leverancier = artikel.getLeverancier();


            data.putIfAbsent(leverancier, new HashMap<>());

            HashMap<Artikel, Integer> artikelCounter = data.get(leverancier);

            artikelCounter.putIfAbsent(artikel, 0);

            artikelCounter.put(
                    artikel,
                    artikelCounter.get(artikel) + 1
            );

        }

        return new MijnLeveringsOverzicht(data);
    }



    public static class MijnLeveringsOverzicht implements LeveringsOverzicht {

        private final HashMap<Leverancier, HashMap<Artikel, Integer>> data;

        public MijnLeveringsOverzicht(HashMap<Leverancier, HashMap<Artikel, Integer>> data) {
            this.data = data;
        }


        @Override
        public Collection<Artikel> getBesteldeArtikels(Leverancier l) {
            return data.get(l).keySet();
        }

        @Override
        public int getAantalArtikels(Leverancier l, Artikel a) {
            return data.get(l).get(a);
        }
    }

}
