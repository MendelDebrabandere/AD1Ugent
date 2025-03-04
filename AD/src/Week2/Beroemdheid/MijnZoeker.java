package Week2.Beroemdheid;

import java.util.ArrayList;
import java.util.List;

public class MijnZoeker implements Zoeker{
    @Override
    public Persoon zoekBeroemdheid(List<Persoon> groep) {

        if (groep.isEmpty()) return null;

        Persoon possible = groep.getFirst();

        for (Persoon p : groep) {
            if (p != possible && !p.kent(possible)) {
                possible = p;
            }
        }

        for (Persoon p : groep) {
            if (p != possible && !p.kent(possible)) {
                return null;
            }
        }

        return possible;
    }
}
