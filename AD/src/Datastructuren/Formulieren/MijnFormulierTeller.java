package Datastructuren.Formulieren;

import java.util.*;

public class MijnFormulierTeller implements FormulierTeller{
    @Override
    public Collection<String> tel(int aantalVerkozenen, List<String> stemmen) {

        Map<String, Integer> stemPerPersoon = new HashMap<>();

        for (String naam : stemmen) {
            stemPerPersoon.putIfAbsent(naam, 0);
            stemPerPersoon.put(naam, stemPerPersoon.get(naam)+1);
        }

        ArrayList<String> namen = new ArrayList<>(stemPerPersoon.keySet().stream().toList());

        //namen.sort((a, b) -> stemPerPersoon.get(b) - stemPerPersoon.get(a));
        namen.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return stemPerPersoon.get(o2) - stemPerPersoon.get(o1);
            }
        });

        return namen.subList(0,aantalVerkozenen);
    }
}
